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

/**
 *
 * @author Skull
 */
public abstract class Role {
    
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
            UserAccount account,
            Enterprise enterprise,
            Business business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
