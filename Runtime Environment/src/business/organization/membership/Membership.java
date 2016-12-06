/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.membership;

/**
 *
 * @author raseswaridas
 */
public class Membership {

    public enum membershipType{
        Platinum,
        Diamond,
        Gold,
        Silver,
        Bronze,
        Steel;
    };
    
    private String name;
    private String description;
    private int price;
    private int durationInDays;
    private Boolean hasSpecialServicesAccess;
    private Boolean hasPersonalTraining;

    private int id;
    private static int count = 0;

    public Membership(String type) {
        count++;
        this.id = count;
        this.name = type;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Boolean getHasSpecialServicesAccess() {
        return hasSpecialServicesAccess;
    }

    public void setHasSpecialServicesAccess(Boolean hasSpecialServicesAccess) {
        this.hasSpecialServicesAccess = hasSpecialServicesAccess;
    }

    public void setHasPersonalTraining(Boolean hasPersonalTraining) {
        this.hasPersonalTraining = hasPersonalTraining;
    }

    public Boolean getHasPersonalTraining() {
        return hasPersonalTraining;
    }
}
