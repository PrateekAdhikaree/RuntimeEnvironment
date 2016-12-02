/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.role.Role;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.person.employee.Employee;
import business.person.customer.Customer;

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
    
    public Boolean createNewUserAccount(String username, String password, Employee employee, Customer customer, Role role) {
        if(checkIfUsernameIsUnique(username)){
            UserAccount userAccount = new UserAccount(role);
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.setEmployee(employee);
            userAccount.setCustomer(customer);
            userAccountlist.add(userAccount);
            return true;
        }
        return false;
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
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountlist)
            if (ua.getUsername().equals(username)){
                try {
                    Boolean isAuthentic = PasswordHash.check(password, ua.getPassword());
                    if(isAuthentic)
                        return ua;
                } catch (Exception ex) {
                    Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return null;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountlist){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
}
