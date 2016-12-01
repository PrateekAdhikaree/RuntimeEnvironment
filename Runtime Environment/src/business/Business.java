/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.enterprise.Enterprise;
import business.parentnetwork.ParentNetworkDirectory;

/**
 *
 * @author Skull
 */
public class Business extends Enterprise {
    
    private static Business business;
    private ParentNetworkDirectory parentNetworkDirectory;
    
    private Business(){
        Initialize initialize = new Initialize(business);
        initialize.createGlobalUsers();
    }
    
    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }

    public ParentNetworkDirectory getParentNetworkDirectory() {
        return parentNetworkDirectory;
    }

    public void setParentNetworkDirectory(ParentNetworkDirectory parentNetworkDirectory) {
        this.parentNetworkDirectory = parentNetworkDirectory;
    }
    
}
