/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountlist;
    
    public UserAccountDirectory(){
        userAccountlist = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getUserAccountlist() {
        return userAccountlist;
    }
    
    public UserAccount addUserAccount(Role role) {
        UserAccount userAccount = new UserAccount(role);
        userAccountlist.add(userAccount);
        return userAccount;
    }

    public UserAccount searchUserAccountById(int id) {
        for (UserAccount ua : userAccountlist) {
            if (ua.getId() == id) {
                return ua;
            }
        }
        return null;
    }

    public void removeUserAccount(UserAccount ua) {
        userAccountlist.remove(ua);
    }
    
}
