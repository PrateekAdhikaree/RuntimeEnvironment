/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.organization.accounting.membership.*;
import business.enterprise.*;
import business.network.*;
import business.organization.*;
import business.organization.accounting.Accounting;
import business.organization.groupclasses.*;
import business.organization.message.*;
import business.organization.promo.PromoDirectory;
import business.parentnetwork.*;
import business.person.Person;
import business.person.customer.*;
import business.person.employee.*;
import business.role.*;
import business.useraccount.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.organization.vendor.Vendor;
import java.text.ParseException;

/**
 *
 * @author Skull
 */
public final class Initialize {
    
    private FileReader file;
    private BufferedReader reader;
    
    public Business configureBusiness(){
        Business business = Business.getInstance();
        createGlobalUsers(business);
        business = readFromCSV(business);
        return business;
    }
    
    private void createGlobalUsers(Business business){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Role role = new SuperAdminRole();
        Employee employee = business.getEmployeeDirectory().addEmployee(role);
        employee.setFirstName("Patricia");
        employee.setLastName("Keith");
        employee.setGender(Person.genderType.Female);
           try {
            employee.setDob(sdf.parse("12/12/1990"));
        } catch (ParseException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        employee.setEmail("superadmin@re.com");
        employee.setMobile("7816245167");
        employee.setAddress("41 Huntington Ave");
        employee.setCity("Boston");
        employee.setCountry("United States");
        employee.setZip("78192");
        Boolean accountCreated = business.getUserAccountDirectory().createNewUserAccount("sysadmin", "sysadmin", employee, null, role, "superadmin@re.com");
        if(!accountCreated)
            Logger.getLogger(Initialize.class.getName()+" in createGlobalUsers()").log(Level.SEVERE, null, "SuperAdmin Account not created!");
        
        
        role = new MarketingRole();
        employee = business.getEmployeeDirectory().addEmployee(role);
        employee.setFirstName("James");
        employee.setLastName("Clinton");
        employee.setGender(Person.genderType.Male);
           try {
            employee.setDob(sdf.parse("12/12/1990"));
        } catch (ParseException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        employee.setEmail("marketing@re.com");
        employee.setMobile("7816729817");
        employee.setAddress("89 Boylston");
        employee.setCity("Boston");
        employee.setState("MA");
        employee.setCountry("Unites States");
        employee.setZip("12389");
        accountCreated = business.getUserAccountDirectory().createNewUserAccount("marketadmin", "marketadmin", employee, null, role, "marketing@re.com");
        if(!accountCreated)
            Logger.getLogger(Initialize.class.getName()+" in createGlobalUsers()").log(Level.SEVERE, null, "MarketAdmin Account not created!");    
        
        role = new VendorRole();
        Vendor vendor = new Vendor();
        vendor.setFirstName("Adam");
        vendor.setLastName("Brian");
        vendor.setEmail("vendor@re.com");
        vendor.setGender(Person.genderType.Male);
        try {
            vendor.setDob(sdf.parse("12/12/1990"));
        } catch (ParseException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        vendor.setAddress("121 Jill");
        vendor.setCity("Boston");
        vendor.setCountry("United States");
        vendor.setState("MA");
        vendor.setZip("02910");
        vendor.setMobile("8989898989");
        accountCreated = business.getUserAccountDirectory().createNewUserAccount("vendor", "vendor", employee, null, role, "vendor@re.com");
        if(!accountCreated)
            Logger.getLogger(Initialize.class.getName()+" in createGlobalUsers()").log(Level.SEVERE, null, "Vendor Account not created!");
    }
    
    private Business readFromCSV(Business business){
        
        ParentNetworkDirectory parentNetworkDirectory = getParentNetworks();
        PromoDirectory promoDirectory = getPromos();
        business.setPromoDirectory(promoDirectory);
        for(ParentNetwork parentNetwork: parentNetworkDirectory.getParentNetworkList()){
            
            NetworkDirectory networkDirectory = getNetworks(parentNetwork.getCountryName());
            parentNetwork.setNetworkDirectory(networkDirectory);
            MembershipDirectory membershipDirectory = getMemberships(parentNetwork);
            for(Network network: networkDirectory.getNetworkList()){
                
                EnterpriseDirectory enterpriseDirectory = getEnterprises(network.getCountry(), network.getCity(), membershipDirectory);
                network.setEnterpriseDirectory(enterpriseDirectory);
                for(Enterprise enterprise: enterpriseDirectory.getEnterpriseList()){
                    
                    OrganizationDirectory organizationDirectory = getOrganizations(enterprise.getCountry(), enterprise.getCity(), enterprise.getBranchName(), parentNetwork, enterprise.getEmployeeDirectory(), enterprise.getCustomerDirectory());
                    enterprise.setOrganizationDirectory(organizationDirectory);
                }
            }
        }
        business.setParentNetworkDirectory(parentNetworkDirectory);
        
        MessageDirectory messageDirectory = getMessages(business);
        business.setMessageDirectory(messageDirectory);
        
        return business;
    }
    
    private ParentNetworkDirectory getParentNetworks(){
            
        ParentNetworkDirectory parentNetworkDirectory = new ParentNetworkDirectory();
        
        try {
            this.file = new FileReader("resources/files/ParentNetworkDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getParentNetworks(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    ParentNetwork parentNetwork = parentNetworkDirectory.addParentNetwork(b[1],Float.parseFloat(b[2]));
                    parentNetwork.setCountryName(b[0]);
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getParentNetworks()").log(Level.SEVERE, null, ex);
        }
         
        return parentNetworkDirectory;
    }
    
    private PromoDirectory getPromos(){
        
        PromoDirectory promoDirectory = new PromoDirectory();
        
        try {
            this.file = new FileReader("resources/files/PromoDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getPromos(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    promoDirectory.addPromo(b[0], Integer.parseInt(b[1]));
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getPromos()").log(Level.SEVERE, null, ex);
        }
         
        return promoDirectory;
    }
    
    private NetworkDirectory getNetworks(String country){
            
        NetworkDirectory networkDirectory = new NetworkDirectory();
        
        try {
            this.file = new FileReader("resources/files/NetworkDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getNetworks(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    if(b[0].equals(country)){
                        Network network = networkDirectory.addNetwork();
                        network.setCity(b[1]);
                        network.setState(b[2]);
                        network.setCountry(b[0]);
                    }
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getNetworks()").log(Level.SEVERE, null, ex);
        }
         
        return networkDirectory;
    }
    
    private EnterpriseDirectory getEnterprises(String country, String city, MembershipDirectory membershipDirectory){
            
        EnterpriseDirectory enterpriseDirectory = new EnterpriseDirectory();
        
        try {
            this.file = new FileReader("resources/files/EnterpriseDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getEnterprises(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    if(b[0].equals(country)){
                        if(b[1].equals(city)){
                            Enterprise enterprise = enterpriseDirectory.addEnterprise(Organization.organizationType.Enterprise, Enterprise.enterpriseType.GymEnterprise);
                            enterprise.setCity(b[1]);
                            enterprise.setCountry(b[0]);
                            enterprise.setState(b[2]);
                            enterprise.setAddress(b[3]);
                            enterprise.setBranchName(b[4]);
                            
                            CustomerDirectory customerDirectory = getCustomers(b[4], membershipDirectory);
                            enterprise.setCustomerDirectory(customerDirectory);
                            
                            EmployeeDirectory employeeDirectory = getEmployees(b[4]);
                            enterprise.setEmployeeDirectory(employeeDirectory);
                            
                            UserAccountDirectory userAccountDirectory = getUserAccounts(b[4], employeeDirectory, customerDirectory);
                            enterprise.setUserAccountDirectory(userAccountDirectory);
                        }
                    }
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getEnterprises()").log(Level.SEVERE, null, ex);
        }
        return enterpriseDirectory;
    }
    
    public MembershipDirectory getMemberships(ParentNetwork parentNetwork){
        MembershipDirectory membershipDirectory = new MembershipDirectory();
        
        try {
            this.file = new FileReader("resources/files/MembershipDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getMemberships(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    Membership membership = membershipDirectory.addMembership(getMembershipType(b[0]), parentNetwork);
                    membership.setDescription(b[1]);
                    membership.setPrice(Integer.parseInt(b[3]));
                    membership.setDurationInDays(Integer.parseInt(b[2]));
                    Boolean hasSpecialServices = false;
                    if(b[0].equals(Membership.membershipType.Platinum.toString()) || b[0].equals(Membership.membershipType.Gold.toString()) || b[0].equals(Membership.membershipType.Bronze.toString())){
                        hasSpecialServices = true;
                    }
                    membership.setHasSpecialServicesAccess(hasSpecialServices);
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getMemberships()").log(Level.SEVERE, null, ex);
        }
        
        return membershipDirectory;
    }
    
    private Membership.membershipType getMembershipType(String str){
        Membership.membershipType type = null;
        if(str.equals(Membership.membershipType.Bronze.toString()))
            type = Membership.membershipType.Bronze;
        else if(str.equals(Membership.membershipType.Diamond.toString()))
            type = Membership.membershipType.Diamond;
        else if(str.equals(Membership.membershipType.Gold.toString()))
            type = Membership.membershipType.Gold;
        else if(str.equals(Membership.membershipType.Platinum.toString()))
            type = Membership.membershipType.Platinum;
        else if(str.equals(Membership.membershipType.Silver.toString()))
            type = Membership.membershipType.Silver;
        else if(str.equals(Membership.membershipType.Steel.toString()))
            type = Membership.membershipType.Steel;
        
        return type;
    }
    
    private CustomerDirectory getCustomers(String branch, MembershipDirectory membershipDirectory){
        CustomerDirectory customerDirectory = new CustomerDirectory();
        
        try {
            this.file = new FileReader("resources/files/CustomerDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getCustomers(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    if(b[12].equals(branch)){
                        Membership membership = null;
                        for(Membership m: membershipDirectory.getMembershipList()){
                            if(b[13].equals(m.getName())){
                                membership = m;
                                break;
                            }
                        }
                        Customer customer = customerDirectory.addCustomer(membership);
                        customer.setAddress(b[8]);
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        customer.setDob(sdf.parse(b[5]));
                        customer.setEmail(b[7]);
                        customer.setGender(getGenderFromCsv(b[4]));
                        customer.setMobile(b[6]);
                        customer.setCity(b[9]);
                        customer.setCountry(b[10]);
                        customer.setFirstName(b[1]);
                        customer.setLastName(b[2]);
                        customer.setZip(b[11]);
                        Boolean hasPersonalTraining = false;
                        if(b[14].equals("Yes"))
                            hasPersonalTraining = true;
                        customer.getMembership().setHasPersonalTraining(hasPersonalTraining);
                    }
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getCustomers()").log(Level.SEVERE, null, ex);
        }
        
        return customerDirectory;
    }
    
    private Person.genderType getGenderFromCsv(String gender){
        Person.genderType type = null;
        if(gender.equals(Person.genderType.Male.toString()))
            type = Person.genderType.Male;
        else if(gender.equals(Person.genderType.Female.toString()))
            type = Person.genderType.Female;
        return type;
    }
    
    private EmployeeDirectory getEmployees(String branch){
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        
        try {
            this.file = new FileReader("resources/files/EmployeeDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getEmployees(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    if(b[1].equals(branch)){
                        Role role = getRoleFromString(b[2]);
                        Employee employee = employeeDirectory.addEmployee(role);
                        employee.setAddress(b[10]);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        employee.setDob(sdf.parse(b[7]));
                        employee.setEmail(b[9]);
                        employee.setCity(b[11]);
                        employee.setCountry(b[12]);
                        employee.setGender(getGenderFromCsv(b[6]));
                        employee.setMobile(b[8]);
                        employee.setFirstName(b[3]);
                        employee.setLastName(b[4]);
                        employee.setZip(b[13]);
                    }
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getEmployees()").log(Level.SEVERE, null, ex);
        }
        
        return employeeDirectory;
    }
    
    private UserAccountDirectory getUserAccounts(String branch, EmployeeDirectory employeeDirectory, CustomerDirectory customerDirectory){
        UserAccountDirectory userAccountDirectory = new UserAccountDirectory();
        
        try {
            this.file = new FileReader("resources/files/UserAccountDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getUserAccounts(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    if(b[0].equals(branch)){
                        Role role = getRoleFromString(b[5]);
                        Employee employee = null;
                        String email = "";
                        if(!b[3].equals("~")){
                            employee = getEmployeeFromString(employeeDirectory, b[3]);
                            email = employee.getEmail();
                        }
                        Customer customer = null;
                        if(!b[4].equals("~")){
                            customer = getCustomerFromString(customerDirectory, b[4]);
                            email = customer.getEmail();
                        }
                        Boolean userAccountCreated = userAccountDirectory.createNewUserAccount(b[1], b[2], employee, customer, role, email);
                        if(!userAccountCreated){
                            Logger.getLogger(Initialize.class.getName()+" in getUserAccounts(): Error in reading file");
                        }
                    }
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getUserAccounts()").log(Level.SEVERE, null, ex);
        }
        
        return userAccountDirectory;
    }
    
    private Employee getEmployeeFromString(EmployeeDirectory employeeDirectory, String text){
        Employee employee = null;
        for(Employee e: employeeDirectory.getEmployeeList()){
            if(e.getEmail().equals(text)){
                employee = e;
                break;
            }
        }
        return employee;
    }
    
    private Customer getCustomerFromString(CustomerDirectory customerDirectory, String text){
        Customer customer = null;
        for(Customer c: customerDirectory.getCustomerList()){
            if(c.getEmail().equals(text)){
                customer = c;
                break;
            }
        }
        return customer;
    }
    
    private Role getRoleFromString(String text){
        Role role = null;
        if(text.equals(Role.RoleType.Accountant.toString())){
            role = new AccountantRole();
        }else if(text.equals(Role.RoleType.Admin.toString())){
            role = new AdminRole();
        }else if(text.equals(Role.RoleType.Customer.toString())){
            role = new CustomerRole();
        }else if(text.equals(Role.RoleType.Maintenance.toString())){
            role = new MaintenanceRole();
        }else if(text.equals(Role.RoleType.Marketing.toString())){
            role = new MarketingRole();
        }else if(text.equals(Role.RoleType.MasterTrainer.toString())){
            role = new MasterTrainerRole();
        }else if(text.equals(Role.RoleType.RegularTrainer.toString())){
            role = new RegularTrainerRole();
        }else if(text.equals(Role.RoleType.SuperAdmin.toString())){
            role = new SuperAdminRole();
        }else if(text.equals(Role.RoleType.Vendor.toString())){
            role = new VendorRole();
        }
        return role;
    }
    
    private OrganizationDirectory getOrganizations(String country, String city, String branch, ParentNetwork parentNetwork, EmployeeDirectory employeeDirectory, CustomerDirectory customerDirectory){
        
        OrganizationDirectory organizationDirectory = new OrganizationDirectory();
        
        Accounting accounting = new Accounting(parentNetwork);
        MembershipDirectory membershipDirectory = getMemberships(parentNetwork);
        accounting.setMembershipDirectory(membershipDirectory);
        accounting.setCustomerDirectory(customerDirectory);
        accounting.setEmployeeDirectory(employeeDirectory);
        organizationDirectory.setAccounting(accounting);
        
        GroupClassesDirectory groupClassesDirectory = getGroupClasses(country, city, branch, employeeDirectory);
        organizationDirectory.setGroupClassesDirectory(groupClassesDirectory);
        
        return organizationDirectory;
    }
    
    private GroupClassesDirectory getGroupClasses(String country, String city, String branch, EmployeeDirectory employeeDirectory){
        
        GroupClassesDirectory groupClassesDirectory = new GroupClassesDirectory();
        
        try {
            this.file = new FileReader("resources/files/GroupClassesDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getGroupClasses(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    if(b[1].equals(country)){
                        if(b[0].equals(city)){
                            if(b[2].equals(branch)){
                                String desc = "";
                                if(b.length > 10){
                                    for(int i = 0; i < b.length-1; i++){
                                        if(i >= 9)
                                            desc += b[i] + ",";
                                    }
                                    desc = desc.substring(0, desc.length()-1);
                                }else{
                                    desc = b[9];
                                }
                                GroupClasses.classType type = b[8].equals(GroupClasses.classType.Customer.toString()) ? GroupClasses.classType.Customer : GroupClasses.classType.Trainer;
                                GroupClasses groupClasses = groupClassesDirectory.addGroupClasses(type);
                                groupClasses.setTrainer(getEmployeeFromString(employeeDirectory, b[5]));
                                groupClasses.setDescription(desc);
                                groupClasses.setCapacity(Integer.parseInt(b[7]));
                                groupClasses.setDuration(Integer.parseInt(b[6]));
                                groupClasses.setTime(b[4]);
                                groupClasses.setName(b[3]);
                            }
                        }
                    }
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getGroupClasses()").log(Level.SEVERE, null, ex);
        }
        
        return groupClassesDirectory;
    }
    
    private MessageDirectory getMessages(Business business){
        MessageDirectory messageDirectory = new MessageDirectory();
        
        try {
            this.file = new FileReader("resources/files/MessageDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getMessages(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    Message.messageType type = null;
                    if(b[4].equals(Message.messageType.Message.toString()))
                        type = Message.messageType.Message;
                    else if(b[4].equals(Message.messageType.WorkOrder.toString()))
                        type = Message.messageType.WorkOrder;
                    else if(b[4].equals(Message.messageType.Query.toString()))
                        type = Message.messageType.Query;
                    
                    Message.statusType status = null;
                    if(b[8].equals(Message.statusType.Completed))
                        status = Message.statusType.Completed;
                    else if(b[8].equals(Message.statusType.Delivered))
                        status = Message.statusType.Delivered;
                    else if(b[8].equals(Message.statusType.InProgressWithMaintenance))
                        status = Message.statusType.InProgressWithMaintenance;
                    else if(b[8].equals(Message.statusType.InProgressWithVendor))
                        status = Message.statusType.InProgressWithVendor;
                    else if(b[8].equals(Message.statusType.Open))
                        status = Message.statusType.Open;
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Message message = messageDirectory.addMessage(type, getUserAccountFromString(business, b[6]), getUserAccountFromString(business, b[7]), status, b[5], b[11], sdf.parse(b[9]));
                    if(!b[10].equals(""))
                        message.setResolveDate(sdf.parse(b[10]));
                }
                row++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getMessages()").log(Level.SEVERE, null, ex);
        }
        
        return messageDirectory;
    }
    
    private UserAccount getUserAccountFromString(Business business, String email){
        UserAccount userAccount = null;
        
        for(UserAccount ua :business.getUserAccountDirectory().getUserAccountlist()){
            if(ua.getEmail().equals(email)){
                userAccount = ua;
            }
        }

        if (userAccount == null) {
            for (ParentNetwork parentnetwork : business.getParentNetworkDirectory().getParentNetworkList()) {
                for (Network network : parentnetwork.getNetworkDirectory().getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for(UserAccount ua :enterprise.getUserAccountDirectory().getUserAccountlist()){
                            if(ua.getEmail().equals(email)){
                                userAccount = ua;
                            }
                        }
                    }
                    if (userAccount != null) {
                        break;
                    }
                }
                if (userAccount != null) {
                    break;
                }
            }
        }
        
        if (userAccount == null) {
            return null;
        } else {
            return userAccount;
        }
    }
    
}
