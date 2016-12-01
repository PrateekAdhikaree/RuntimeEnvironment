/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.groupclasses;

import business.organization.Organization;
import business.role.RegularTrainerRole;
import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class GroupClasses extends Organization {

    private String name;
    private int duration;
    private String description;
    private ArrayList<RegularTrainerRole> trainerList;

    private int id;
    private static int count = 0;

    public GroupClasses() {
        count++;
        id = count;
        trainerList = new ArrayList<RegularTrainerRole>();
    }

    public ArrayList<RegularTrainerRole> getTrainerList() {
        return trainerList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RegularTrainerRole addTrainer() {
        RegularTrainerRole trainer = new RegularTrainerRole();
        trainerList.add(trainer);
        return trainer;
    }

}
