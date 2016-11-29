/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.branch;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class BranchDirectory {
    
    private ArrayList<Branch> branchList;

    private BranchDirectory() {
        branchList = new ArrayList<Branch>();
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public Branch addBranch() {
        Branch branch = new Branch();
        branchList.add(branch);
        return branch;
    }

    public Branch searchBranchById(int id) {
        for (Branch branch : branchList) {
            if (branch.getId() == id) {
                return branch;
            }
        }
        return null;
    }

    public void removeBranch(Branch branch) {
        branchList.remove(branch);
    }
    
}
