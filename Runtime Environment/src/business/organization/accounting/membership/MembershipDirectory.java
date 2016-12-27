/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.accounting.membership;

import business.parentnetwork.ParentNetwork;
import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class MembershipDirectory {
    
    private ArrayList<Membership> membershipList;
    
    public MembershipDirectory(){
        membershipList = new ArrayList<Membership>();
    }

    public ArrayList<Membership> getMembershipList() {
        return membershipList;
    }
    
    public Membership addMembership(Membership.membershipType type, ParentNetwork parentNetwork){
        Membership membership = new Membership(type, parentNetwork);
        membershipList.add(membership);
        return membership;
    }
    
    public Membership searchMembershipById(int id){
        for(Membership membership : membershipList){
            if(membership.getId() == id){
                return membership;
            }
        }
        return null;
    }
    
    public void removeMembership(Membership membership){
        membershipList.remove(membership);
    }
    
}
