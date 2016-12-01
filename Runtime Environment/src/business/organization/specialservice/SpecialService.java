/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.specialservice;

import business.organization.Organization;
import business.organization.membership.Membership;

/**
 *
 * @author raseswaridas
 */
public class SpecialService extends Organization {
    
    private String name;
    private String description;
    
    private int id;
    private static int count = 0;
    
    public SpecialService(){
        count++;
        id = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
 
    public Boolean isAvailableInMembership(Membership m){;
        for(SpecialService services : m.getSpecialServiceList()){
            if(services.getId() == this.id){
                return true;
            }
        }
        return false;
    }
    
}
