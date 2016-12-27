/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise addEnterprise(Organization.organizationType orgType, Enterprise.enterpriseType entType) {
        Enterprise enterprise = new GymEnterprise(orgType, entType);
        enterpriseList.add(enterprise);
        return enterprise;
    }

    public Enterprise searchEnterpriseById(int id) {
        for (Enterprise enterprise : enterpriseList) {
            if (enterprise.getId() == id) {
                return enterprise;
            }
        }
        return null;
    }

    public void removeEnterprise(GymEnterprise enterprise) {
        enterpriseList.remove(enterprise);
    }
    
}
