/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.message.MessageDirectory;
import business.person.customer.CustomerDirectory;
import business.person.employee.EmployeeDirectory;
import business.useraccount.UserAccountDirectory;

/**
 *
 * @author Skull
 */
public abstract class Organization {
    
    public enum organizationType{
        Message, WorkOrder, GroupClasses, SpecialService, Vendor, Account, Business, Enterprise;
    };
    
    private int id;
    private static int count = 0;
    private String name;
    
    private EmployeeDirectory employeeDirectory;
    private CustomerDirectory customerDirectory;
    private UserAccountDirectory userAccountDirectory;
    private MessageDirectory messageDirectory;
    private organizationType type;
    
    public Organization(organizationType type){
        id = count;
        count++;
        this.type = type;
        employeeDirectory = new EmployeeDirectory();
        customerDirectory = new CustomerDirectory();
        userAccountDirectory = new UserAccountDirectory();
        messageDirectory = new MessageDirectory();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public MessageDirectory getMessageDirectory() {
        return messageDirectory;
    }

    public void setMessageDirectory(MessageDirectory messageDirectory) {
        this.messageDirectory = messageDirectory;
    }
    
}
