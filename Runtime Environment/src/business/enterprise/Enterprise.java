/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.OrganizationDirectory;
import business.organization.message.Message;
import business.person.customer.CustomerDirectory;
import business.person.employee.EmployeeDirectory;
import business.useraccount.UserAccountDirectory;

/**
 *
 * @author Skull
 */
public abstract class Enterprise {
    
    private int id;
    private static int count = 0;
    
    private EmployeeDirectory employeeDirectory;
    private CustomerDirectory customerDirectory;
    private UserAccountDirectory userAccountDirectory;
    private Message messageQueue;
    
    private OrganizationDirectory organizationDirectory;
    
    public Enterprise(){
        count++;
        id = count;
    }

    public int getId() {
        return id;
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

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public Message getMessageQueue() {
        return messageQueue;
    }

    public void setMessageQueue(Message messageQueue) {
        this.messageQueue = messageQueue;
    }
    
}
