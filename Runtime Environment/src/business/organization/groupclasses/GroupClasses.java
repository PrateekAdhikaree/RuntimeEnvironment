/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.groupclasses;

import business.organization.Organization;
import business.person.employee.Employee;

/**
 *
 * @author raseswaridas
 */
public class GroupClasses extends Organization {

    private String name;
    private int duration;
    private String description;
    private String time;
    private Employee trainer;
    private classType type;
    
    public enum classType{
        Trainer, Customer;
    }

    private int id;
    private static int count = 0;

    public GroupClasses(classType type) {
        super(organizationType.GroupClasses);
        this.type = type;
        count++;
        id = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Employee getTrainer() {
        return trainer;
    }

    public void setTrainer(Employee trainer) {
        this.trainer = trainer;
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

}
