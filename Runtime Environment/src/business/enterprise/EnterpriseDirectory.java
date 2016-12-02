/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    private EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise addBranch() {
        Enterprise enterprise = new GymEnterprise();
        enterpriseList.add(enterprise);
        return enterprise;
    }

    public Enterprise searchBranchById(int id) {
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
