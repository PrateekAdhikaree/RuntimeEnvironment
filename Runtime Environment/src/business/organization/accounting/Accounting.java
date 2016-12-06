/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.accounting;

import business.organization.Organization;
import business.organization.membership.MembershipDirectory;
import business.person.customer.Customer;
import business.person.customer.CustomerDirectory;
import business.person.employee.Employee;
import business.person.employee.EmployeeDirectory;

/**
 *
 * @author raseswaridas
 */
public class Accounting extends Organization{
    
    private int currentFunds;
    private MembershipDirectory membershipDirectory;
    
    public Accounting(){
        super(organizationType.Account);
    }

    public int getCurrentFunds() {
        return currentFunds;
    }
    
    public void setCurrentFunds(int value){
        currentFunds = value;
    }

    public MembershipDirectory getMembershipDirectory() {
        return membershipDirectory;
    }

    public void setMembershipDirectory(MembershipDirectory membershipDirectory) {
        this.membershipDirectory = membershipDirectory;
    }

    public void calculateRevenue(EmployeeDirectory employeeDirectory, CustomerDirectory customerDirectory, int months) {
        int totalFunds = 0;
        int totalEmployeeSalary = 0;
        int totalCustomerFees = 0;
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
        this.currentFunds = totalFunds;
    }
    
    public int calculateCustomerFees(Customer customer){
        int price = 0;
        price = customer.getMembership().getPrice();
        price = (price / customer.getMembership().getDurationInDays()) * 30;
        if(customer.getMembership().getHasPersonalTraining()){
            price += 50;
        }
        return price;
    }
    
}
