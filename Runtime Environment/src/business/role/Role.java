/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import javax.swing.JPanel;
import business.useraccount.UserAccount;
import business.*;
import business.enterprise.Enterprise;
import business.organization.accounting.Accounting;

/**
 *
 * @author Skull
 */
public abstract class Role {
    
    public Role(){
        setSalary();
        
    }
    
    protected int salary;
    
    public static enum RoleType{
        Accountant,
        Admin,
        Customer,
        Maintenance,
        Marketing,
        MasterTrainer,
        RegularTrainer,
        SuperAdmin,
        Vendor;
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount userAccount,
            Enterprise enterprise,
            Business business);
    
        public abstract JPanel createProfile(JPanel userProcessContainer, 
            UserAccount userAccount,
            Accounting accounting,
            Business business);

    public abstract void setSalary();
    
    public abstract RoleType getRoleType();
    
    public void setSalary(int salary){
        this.salary = salary;
    }
    
    public int getSalary(){
        return salary;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
