/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.accounting;

import business.organization.Organization;
import business.organization.accounting.membership.MembershipDirectory;
import business.parentnetwork.ParentNetwork;
import business.person.customer.*;
import business.person.employee.*;

/**
 *
 * @author raseswaridas
 */
public class Accounting extends Organization{
    
    private float currentFunds;
    private MembershipDirectory membershipDirectory;
    private String currency;
    private float currencyMultiplier;
    
    public Accounting(ParentNetwork parentNetwork){
        super(organizationType.Account);
        setParentNetworkCurrency(parentNetwork);
    }

    private void setParentNetworkCurrency(ParentNetwork parentNetwork){
        this.currency = parentNetwork.getCurrency();
        this.currencyMultiplier = parentNetwork.getCurrencyMultiplier();
    }
    
    public float getCurrentFunds() {
        return currentFunds;
    }
    
    public void setCurrentFunds(float value){
        currentFunds = value;
    }

    public MembershipDirectory getMembershipDirectory() {
        return membershipDirectory;
    }

    public void setMembershipDirectory(MembershipDirectory membershipDirectory) {
        this.membershipDirectory = membershipDirectory;
    }

    public float calculateRevenue(int months) {
        float totalFunds = 0;
        float totalEmployeeSalary = 0;        
        float totalCustomerFees = 0;
        for(Employee employee : employeeDirectory.getEmployeeList()){
            totalEmployeeSalary += employee.getRole().getSalary();
        }
        
        for(Customer customer : customerDirectory.getCustomerList()){
            totalCustomerFees += calculateCustomerFees(customer);
        }
        
        //Calculates revenue for 1 month
        totalFunds = totalCustomerFees - totalEmployeeSalary;
        //Calculates revenue for required months
        totalFunds = totalFunds * months;
        
        currentFunds = totalFunds;
        
        return totalFunds;
    }
    
    public float calculateCustomerFees(Customer customer){
        float price = 0;
        price = customer.getMembership().getPrice();
        price = (price / customer.getMembership().getDurationInDays()) * 30;
        if(customer.getMembership().getHasPersonalTraining()){
            // personal training is $50 more per month
            price += 50;
        }
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public float getCurrencyMultiplier() {
        return currencyMultiplier;
    }
    
}
