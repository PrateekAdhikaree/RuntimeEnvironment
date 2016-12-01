/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.accounting.Accounting;
import business.organization.OrganizationDirectory;
import business.organization.vendor.Vendor;
import business.organization.specialservice.SpecialServiceDirectory;
import business.organization.message.MessageQueueDirectory;
import business.organization.groupclasses.GroupClassesDirectory;
import business.organization.membership.MembershipDirectory;
import business.person.customer.CustomerDirectory;
import business.person.employee.EmployeeDirectory;
import business.useraccount.UserAccountDirectory;

/**
 *
 * @author Skull
 */
public class Enterprise {
    
    private int id;
    private static int count = 0;
    
    private EmployeeDirectory employeeDirectory;
    private CustomerDirectory customerDirectory;
    private UserAccountDirectory userAccountDirectory;
    
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
    
}
