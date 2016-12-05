/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.accounting;

import business.organization.Organization;
import business.organization.membership.MembershipDirectory;

/**
 *
 * @author raseswaridas
 */
public class Accounting extends Organization{
    
    private MembershipDirectory membershipDirectory;
    private int currentFunds;
    
    public Accounting(){
        super(organizationType.Account);
    }

    public MembershipDirectory getMembershipDirectory() {
        return membershipDirectory;
    }

    public void setMembershipDirectory(MembershipDirectory membershipDirectory) {
        this.membershipDirectory = membershipDirectory;
    }

    public int getCurrentFunds() {
        return currentFunds;
    }

    public void setCurrentFunds(int currentFunds) {
        this.currentFunds = currentFunds;
    }
    
}
