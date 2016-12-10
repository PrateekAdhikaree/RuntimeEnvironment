/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.enterprise.Enterprise;
import business.organization.accounting.Accounting;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.accountantrole.AccountantProfileJPanel;
import userinterface.accountantrole.AccountantWorkAreaJPanel;

/**
 *
 * @author raseswaridas
 */
public class AccountantRole extends Role {
    
    public void setSalary(){
        salary = 1000;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Business business){
        return new AccountantWorkAreaJPanel(userProcessContainer, userAccount, enterprise, business);
    }
        
    @Override
    public JPanel createProfile(JPanel userProcessContainer, UserAccount userAccount, Accounting accounting, Business business){
        return new AccountantProfileJPanel(userProcessContainer, userAccount, accounting, business);
    }
    
}
