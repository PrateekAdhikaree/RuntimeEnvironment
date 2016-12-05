/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person.customer;

import business.organization.membership.Membership;
import business.person.Person;

/**
 *
 * @author raseswaridas
 */
public class Customer extends Person {
    
    private int id;
    private static int count = 0;
    private Membership membership;
    private Boolean hasPersonalTraining;
    
    public Customer (Membership membership){
        id = count;
        count++;
        this.membership = membership;
    }

    public int getId() {
        return id;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setHasPersonalTraining(Boolean hasPersonalTraining) {
        this.hasPersonalTraining = hasPersonalTraining;
    }

    public Boolean getHasPersonalTraining() {
        return hasPersonalTraining;
    }
    
}
