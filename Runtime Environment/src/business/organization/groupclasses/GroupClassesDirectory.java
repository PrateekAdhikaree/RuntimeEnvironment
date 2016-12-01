/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.groupclasses;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class GroupClassesDirectory {
    
    private ArrayList<GroupClasses> groupClassesList;

    private GroupClassesDirectory() {
        groupClassesList = new ArrayList<GroupClasses>();
    }

    public ArrayList<GroupClasses> getGroupClassesList() {
        return groupClassesList;
    }

    public GroupClasses addGroupClasses() {
        GroupClasses groupClasses = new GroupClasses();
        groupClassesList.add(groupClasses);
        return groupClasses;
    }

    public GroupClasses searchGroupClassesById(int id) {
        for (GroupClasses groupClasses : groupClassesList) {
            if (groupClasses.getId() == id) {
                return groupClasses;
            }
        }
        return null;
    }

    public void removeGroupClasses(GroupClasses groupClasses) {
        groupClassesList.remove(groupClasses);
    }
    
}
