/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Organization;
import business.organization.OrganizationDirectory;

/**
 *
 * @author Skull
 */
public abstract class Enterprise extends Organization {
    
    private int id;
    private static int count = 0;
    
    private OrganizationDirectory organizationDirectory;
    private enterpriseType type;
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
    
}
