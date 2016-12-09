/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Organization;
import business.organization.OrganizationDirectory;
import business.organization.accounting.membership.MembershipDirectory;

/**
 *
 * @author Skull
 */
public abstract class Enterprise extends Organization {
    
    protected int id;
    protected static int count = 0;
    
    protected String country;
    protected String city;
    protected String state;
    protected String branchName;
    protected String address;
    protected OrganizationDirectory organizationDirectory;
    protected MembershipDirectory membershipDirectory;
    protected enterpriseType type;
    public enum enterpriseType{
        GymEnterprise
    };
    
    public Enterprise(organizationType orgType, enterpriseType entType){
        super(orgType);
        count++;
        id = count;
        this.type = entType;
    }

    public int getId() {
        return id;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public enterpriseType getType() {
        return type;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MembershipDirectory getMembershipDirectory() {
        return membershipDirectory;
    }

    public void setMembershipDirectory(MembershipDirectory membershipDirectory) {
        this.membershipDirectory = membershipDirectory;
    }
    
    @Override
    public String toString(){
        return branchName;
    }
}
