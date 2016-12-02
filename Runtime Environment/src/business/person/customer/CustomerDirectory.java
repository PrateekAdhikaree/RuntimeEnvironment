/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person.customer;

import business.organization.membership.Membership;
import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerList;

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

   public Customer addCustomer(Membership membership){
   Customer customer =  new Customer(membership);
   customerList.add(customer);
   return customer;
   }
   
    public Customer searchCustomerById(int id){
        for(Customer customer : customerList){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }
    
    public void removeCustomer(Customer customer){
        customerList.remove(customer);
    }
    
}
