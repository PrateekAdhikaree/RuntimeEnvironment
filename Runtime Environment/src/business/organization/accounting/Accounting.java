/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.accounting;

import business.organization.Organization;

/**
 *
 * @author raseswaridas
 */
public class Accounting extends Organization{
    
    private int currentFunds;

    public int getCurrentFunds() {
        return currentFunds;
    }

    public void setCurrentFunds(int currentFunds) {
        this.currentFunds = currentFunds;
    }
    
}
