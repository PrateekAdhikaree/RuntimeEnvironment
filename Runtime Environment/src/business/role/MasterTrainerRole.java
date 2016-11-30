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
import userinterface.mastertrainerrole.MasterTrainerWorkAreaJPanel;

/**
 *
 * @author raseswaridas
 */
public class MasterTrainerRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Branch branch, Business business){
        return new MasterTrainerWorkAreaJPanel(userProcessContainer, account, business); // set constructor of MasterTrainerWorkAreaJPanel
    }
    
}
