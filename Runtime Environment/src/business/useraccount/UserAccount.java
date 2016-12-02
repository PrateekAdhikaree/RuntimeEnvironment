/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.organization.message.Message;
import business.person.employee.Employee;
import business.role.Role;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.person.customer.Customer;

/**
 *
 * @author raseswaridas
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Customer customer;
    private Role role;
    private Message messageQueue;
    
    private static int count = 0;
    private int id;

    public UserAccount(Role role) {
        count++;
        id = count;
        this.role = role;
    }

    public Message getMessageQueue() {
        return messageQueue;
    }

    public int getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        try {
            String hashedPassword = PasswordHash.getSaltedHash(password);
            this.password = hashedPassword;
        } catch (Exception ex) {
            Logger.getLogger(UserAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
