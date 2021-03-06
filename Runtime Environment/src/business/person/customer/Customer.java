/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person.customer;

import business.organization.accounting.membership.Membership;
import business.person.Person;

/**
 *
 * @author raseswaridas
 */
public class Customer extends Person {
    
    private int id;
    private static int count = 0;
    private Membership membership;
    
    public Customer (Membership membership){
        count++;
        id = count;
        this.membership = membership;
    }

    public int getId() {
        return id;
    }

    public Membership getMembership() {
        return membership;
    }
    
    @Override
    public String toString(){
        return Integer.toString(id);
    }
}
