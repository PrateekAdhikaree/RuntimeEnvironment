/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

/**
 *
 * @author raseswaridas
 */
public class GymEnterprise extends Enterprise {
    
    public GymEnterprise(organizationType orgType, enterpriseType entType){
        super(orgType, entType);
    }

    private final String name = "Runtime Environment";

    public String getName() {
        return name;
    }
}
