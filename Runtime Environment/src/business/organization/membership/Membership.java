/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.membership;

import business.parentnetwork.ParentNetwork;

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
    private float price;
    private int durationInDays;
    private Boolean hasSpecialServicesAccess;
    private Boolean hasPersonalTraining;
    private String currency;
    private float currencyMultiplier;

    private int id;
    private static int count = 0;

    public Membership(String type, ParentNetwork parentNetwork) {
        count++;
        this.id = count;
        this.name = type;
        setParentNetworkCurrency(parentNetwork);
    }

    private void setParentNetworkCurrency(ParentNetwork parentNetwork){
        this.currency = parentNetwork.getCurrency();
        this.currencyMultiplier = parentNetwork.getCurrencyMultiplier();
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public String getCurrency() {
        return currency;
    }

    public float getCurrencyMultiplier() {
        return currencyMultiplier;
    }
}
