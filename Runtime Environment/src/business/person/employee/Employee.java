/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person.employee;

import business.person.Person;
import business.role.Role;

/**
 *
 * @author raseswaridas
 */
public class Employee extends Person {
    
    private int id;
    private static int count = 0;
    private Role role;
    
    public Employee (Role role){
        id = count;
        count++;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }
    
}
