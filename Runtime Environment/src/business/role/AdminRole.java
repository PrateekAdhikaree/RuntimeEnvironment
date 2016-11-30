/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.branch.Branch;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.adminrole.AdminRoleWorkAreaJPanel;

/**
 *
 * @author raseswaridas
 */
public class AdminRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Branch branch, Business business){
        return new AdminRoleWorkAreaJPanel(userProcessContainer, userAccount, branch, business);
    }
    
}
