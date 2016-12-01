/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.membership;

import business.organization.Organization;
import business.organization.specialservice.SpecialService;
import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class Membership extends Organization {

    private enum membershipType{
//        Gold("Gold"),
//        Platinum("Platinum");
//    
//        private String value;
//        private messageType(String value){
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        @Override
//        public String toString() {
//            return value;
//        }
    };
    
    private String membershipName;
    private String description;
    private int price;
    private ArrayList<SpecialService> specialServiceList;

    private int id;
    private static int count = 0;

    public Membership() {
        count++;
        id = count;
        specialServiceList = new ArrayList<SpecialService>();
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
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

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SpecialService> getSpecialServiceList() {
        return specialServiceList;
    }

    public void addSpecialService(SpecialService specialService) {
        specialServiceList.add(specialService);
    }
}
