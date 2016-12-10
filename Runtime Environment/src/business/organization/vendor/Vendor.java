/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.vendor;

import business.organization.Organization;
import business.person.Person;
import java.util.Date;

/**
 *
 * @author raseswaridas
 */
public class Vendor extends Organization {
    
    private String firstName;
    private String lastName;
    private Person.genderType gender;
    private String address;
    private String email;
    private String mobile;
    private Date dob;
    private String zip;
    private String city;
    private String state;
    private String country;
    private int vendorId;
    private static int count = 0;
    
    public Vendor(){
        super(organizationType.Vendor);
        count++;
        vendorId = count;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Vendor.count = count;
    }

    public Person.genderType getGender() {
        return gender;
    }

    public void setGender(Person.genderType gender) {
        this.gender = gender;
    }

    public int getVendorId() {
        return vendorId;
    }

  
}
