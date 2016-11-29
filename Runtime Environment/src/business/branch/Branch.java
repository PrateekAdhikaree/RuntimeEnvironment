/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.branch;

import business.branch.groupclasses.GroupClassesDirectory;
import business.branch.membership.MembershipDirectory;
import business.branch.message.MessageDirectory;
import business.branch.specialservice.SpecialServiceDirectory;
import business.branch.workorder.WorkOrderDirectory;

/**
 *
 * @author raseswaridas
 */
public class Branch {
    
    private MembershipDirectory membershipDirectory;
    private MessageDirectory messageDirectory;
    private WorkOrderDirectory workOrderDirectory;
    private GroupClassesDirectory groupClassesDirectory;
    private SpecialServiceDirectory sevicesDirectory;
    private Vendor vendor;
    private Accounting accounting;
    
    private int id;
    private static int count = 0;
    
    public Branch(){
        count++;
        id = count;
    }

    public MembershipDirectory getMembershipDirectory() {
        return membershipDirectory;
    }

    public void setMembershipDirectory(MembershipDirectory membershipDirectory) {
        this.membershipDirectory = membershipDirectory;
    }

    public MessageDirectory getMessageDirectory() {
        return messageDirectory;
    }

    public void setMessageDirectory(MessageDirectory messageDirectory) {
        this.messageDirectory = messageDirectory;
    }

    public WorkOrderDirectory getWorkOrderDirectory() {
        return workOrderDirectory;
    }

    public void setWorkOrderDirectory(WorkOrderDirectory workOrderDirectory) {
        this.workOrderDirectory = workOrderDirectory;
    }

    public GroupClassesDirectory getGroupClassesDirectory() {
        return groupClassesDirectory;
    }

    public void setGroupClassesDirectory(GroupClassesDirectory groupClassesDirectory) {
        this.groupClassesDirectory = groupClassesDirectory;
    }

    public SpecialServiceDirectory getSevicesDirectory() {
        return sevicesDirectory;
    }

    public void setSevicesDirectory(SpecialServiceDirectory sevicesDirectory) {
        this.sevicesDirectory = sevicesDirectory;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Accounting getAccounting() {
        return accounting;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;
    }

    public int getId() {
        return id;
    }
    
}
