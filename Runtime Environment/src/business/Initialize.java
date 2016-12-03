/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.network.Network;
import business.network.NetworkDirectory;
import business.organization.Organization;
import business.parentnetwork.ParentNetworkDirectory;
import business.parentnetwork.ParentNetwork;
import business.person.employee.Employee;
import business.role.MarketingRole;
import business.role.Role;
import business.role.SuperAdminRole;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
//        readFromCSV(business);
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
        for(ParentNetwork pn: parentNetworkDirectory.getParentNetworkList()){
            NetworkDirectory networkDirectory = getNetworks(pn.getCountryName());
            pn.setNetworkDirectory(networkDirectory);
            for(Network n: networkDirectory.getNetworkList()){
                EnterpriseDirectory ed = getEnterprises(n.getCountry(), n.getCity());
                n.setEnterpriseDirectory(ed);
                for(Enterprise enterprise: ed.getEnterpriseList()){
//                    OrganizationDirectory od = getOrganizations();                  
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
                    if(b[0].equals(country)){
                        Network network = networkDirectory.addNetwork();
//                    network.setCity(b[0]);
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
            Logger.getLogger(Initialize.class.getName()+" in getNetworks(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    if(b[0].equals(country)){
                        if(b[0].equals(city)){
                            Enterprise enterprise = enterpriseDirectory.addEnterprise(Organization.organizationType.Enterprise, Enterprise.enterpriseType.GymEnterprise);
//                            enterprise.setOrganizationDirectory();
                    
                        }
                    }
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getNetworks()").log(Level.SEVERE, null, ex);
        }
         
        return enterpriseDirectory;
    }
    
    
    
}
