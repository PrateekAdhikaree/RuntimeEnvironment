/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.enterprise.*;
import business.network.*;
import business.organization.*;
import business.organization.accounting.Accounting;
import business.organization.groupclasses.*;
import business.organization.membership.*;
import business.organization.message.Message;
import business.organization.message.MessageDirectory;
import business.parentnetwork.*;
import business.person.Person;
import business.person.customer.Customer;
import business.person.customer.CustomerDirectory;
import business.person.employee.Employee;
import business.person.employee.EmployeeDirectory;
import business.role.*;
import business.useraccount.UserAccount;
import business.useraccount.UserAccountDirectory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        readFromCSV(business);
        return business;
    }
    
    private void createGlobalUsers(Business business){
        Role role = new SuperAdminRole();
        Employee employee = business.getEmployeeDirectory().addEmployee(role);
        Boolean accountCreated = business.getUserAccountDirectory().createNewUserAccount("sysadmin", "sysadmin", employee, null, new SuperAdminRole());
        if(!accountCreated)
            Logger.getLogger(Initialize.class.getName()+" in createGlobalUsers()").log(Level.SEVERE, null, "SuperAdmin Account not created!");
        
        role = new MarketingRole();
        employee = business.getEmployeeDirectory().addEmployee(role);
        accountCreated = business.getUserAccountDirectory().createNewUserAccount("marketadmin", "marketadmin", employee, null, new MarketingRole());
        if(!accountCreated)
            Logger.getLogger(Initialize.class.getName()+" in createGlobalUsers()").log(Level.SEVERE, null, "MarketAdmin Account not created!");    
    }
    
    private Business readFromCSV(Business business){
        ParentNetworkDirectory parentNetworkDirectory = getParentNetworks();
        for(ParentNetwork parentNetwork: parentNetworkDirectory.getParentNetworkList()){
            NetworkDirectory networkDirectory = getNetworks(parentNetwork.getCountryName());
            parentNetwork.setNetworkDirectory(networkDirectory);
            for(Network network: networkDirectory.getNetworkList()){
                EnterpriseDirectory enterpriseDirectory = getEnterprises(network.getCountry(), network.getCity());
                network.setEnterpriseDirectory(enterpriseDirectory);
                for(Enterprise enterprise: enterpriseDirectory.getEnterpriseList()){
                    OrganizationDirectory organizationDirectory = getOrganizations(enterprise.getCountry(), enterprise.getCity(), enterprise.getBranchName());
                    enterprise.setOrganizationDirectory(organizationDirectory);
                }
            }
        }
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
                    ParentNetwork parentNetwork = parentNetworkDirectory.addParentNetwork();
                    parentNetwork.setCountryName(b[0]);
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getParentNetworks()").log(Level.SEVERE, null, ex);
        }
         
        return parentNetworkDirectory;
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
                    if(b[1].equals(country)){
                        Network network = networkDirectory.addNetwork();
                        network.setCity(b[0]);
                    }
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getNetworks()").log(Level.SEVERE, null, ex);
        }
         
        return networkDirectory;
    }
    
    private EnterpriseDirectory getEnterprises(String country, String city){
            
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
                    if(b[1].equals(country)){
                        if(b[0].equals(city)){
                            Enterprise enterprise = enterpriseDirectory.addEnterprise(Organization.organizationType.Enterprise, Enterprise.enterpriseType.GymEnterprise);
                            enterprise.setCity(b[1]);
                            enterprise.setCountry(b[0]);
                            enterprise.setState(b[2]);
                            enterprise.setAddress(b[3]);
                            enterprise.setBranchName(b[4]);
                            
                            MembershipDirectory membershipDirectory = new MembershipDirectory();
                            enterprise.setMembershipDirectory(membershipDirectory);
                            
                            CustomerDirectory customerDirectory = getCustomers(b[4], membershipDirectory);
                            enterprise.setCustomerDirectory(customerDirectory);
                            
                            EmployeeDirectory employeeDirectory = getEmployees(country, city, b[4]);
                            enterprise.setEmployeeDirectory(employeeDirectory);
                            
                            UserAccountDirectory userAccountDirectory = getUserAccounts(country, city, b[4]);
                            enterprise.setUserAccountDirectory(userAccountDirectory);
                        }
                    }
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getEnterprises()").log(Level.SEVERE, null, ex);
        }
        return enterpriseDirectory;
    }
    
    public MembershipDirectory getMemberships(){
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
                    Membership membership = membershipDirectory.addMembership(b[0]);
                    membership.setDescription(b[1]);
                    membership.setPrice(Integer.parseInt(b[3]));
                    membership.setDurationInDays(Integer.parseInt(b[2]));
                    Boolean hasSpecialServices = false;
                    if(b[0].equals(Membership.membershipType.Platinum) || b[0].equals(Membership.membershipType.Gold) || b[0].equals(Membership.membershipType.Bronze)){
                        hasSpecialServices = true;
                    }
                    membership.setHasSpecialServicesAccess(hasSpecialServices);
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getMemberships()").log(Level.SEVERE, null, ex);
        }
        
        return membershipDirectory;
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
                        if(b[4].equals(Person.genderType.Male))
                            customer.setGender(Person.genderType.Male);
                        else if(b[4].equals(Person.genderType.Female))
                            customer.setGender(Person.genderType.Female);
                        customer.setMobile(b[6]);
                        customer.setName(b[1]+" "+b[2]);
                        customer.setZip(b[11]);
                    }
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getCustomers()").log(Level.SEVERE, null, ex);
        }
        
        return customerDirectory;
    }
    
    private UserAccountDirectory getUserAccounts(String country, String city, String branch){
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
                    if(b[1].equals(country)){
                        if(b[0].equals(city)){
                            if(b[2].equals(branch)){
                                Role role = null;
                                if(b[5].equals(Role.RoleType.Accountant.toString())){
                                    role = new AccountantRole();
                                }else if(b[5].equals(Role.RoleType.Admin.toString())){
                                    role = new AdminRole();
                                }else if(b[5].equals(Role.RoleType.Customer.toString())){
                                    role = new CustomerRole();
                                }else if(b[5].equals(Role.RoleType.Maintenance.toString())){
                                    role = new MaintenanceRole();
                                }else if(b[5].equals(Role.RoleType.Marketing.toString())){
                                    role = new MarketingRole();
                                }else if(b[5].equals(Role.RoleType.MasterTrainer.toString())){
                                    role = new MasterTrainerRole();
                                }else if(b[5].equals(Role.RoleType.RegularTrainer.toString())){
                                    role = new RegularTrainerRole();
                                }else if(b[5].equals(Role.RoleType.SuperAdmin.toString())){
                                    role = new SuperAdminRole();
                                }else if(b[5].equals(Role.RoleType.Vendor.toString())){
                                    role = new VendorRole();
                                }
                                UserAccount userAccount = userAccountDirectory.createNewUserAccount(line, country, employee, customer, role);
                            }
                        }
                    }
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getUserAccounts()").log(Level.SEVERE, null, ex);
        }
        
        return userAccountDirectory;
    }
    
    private OrganizationDirectory getOrganizations(String country, String city, String branch){
        
        OrganizationDirectory organizationDirectory = new OrganizationDirectory();
        
        Accounting accounting = new Accounting();
        organizationDirectory.setAccounting(accounting);
        
        GroupClassesDirectory groupClassesDirectory = getGroupClasses(country, city, branch);
        organizationDirectory.setGroupClassesDirectory(groupClassesDirectory);
        
        
        MessageDiretory messageDirectory = getMessages(country, city, branch);
        
        return organizationDirectory;
    }
    
    private GroupClassesDirectory getGroupClasses(String country, String city, String branch){
        
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
                                GroupClasses groupClasses = groupClassesDirectory.addGroupClasses();
                                groupClasses.setCalories(Integer.parseInt(b[4]));
                                groupClasses.setDescription(b[3]);
                                groupClasses.setDuration(Integer.parseInt(b[5]));
                                groupClasses.setName(b[6]);
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
    
    private MessageDirectory getMessages(String country, String city, String branch){
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
                    if(b[1].equals(country)){
                        if(b[0].equals(city)){
                            if(b[2].equals(branch)){
                                Message.messageType type;
                                if(b[3].equals(Message.messageType.Message))
                                    type = Message.messageType.Message;
                                else
                                    type = Message.messageType.WorkOrder;
                                
                                messageDirectory.addMessage(type, sender, receiver, Message.statusType.Open, line);
                            }
                        }
                    }
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getMessages()").log(Level.SEVERE, null, ex);
        }
        
        return messageDirectory;
    }
    
}
