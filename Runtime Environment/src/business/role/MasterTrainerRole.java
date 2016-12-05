/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.enterprise.Enterprise;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.mastertrainerrole.MasterTrainerWorkAreaJPanel;

/**
 *
 * @author raseswaridas
 */
public class MasterTrainerRole extends Role {
    
    public void setSalary(){
        salary = 2500;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Business business){
        return new MasterTrainerWorkAreaJPanel(userProcessContainer, userAccount, enterprise, business);
    }
    
}
