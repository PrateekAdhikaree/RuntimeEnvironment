/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class CountryDirectory {

    private ArrayList<Country> countryList;

    private CountryDirectory() {
        countryList = new ArrayList<Country>();
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public Country addCountry() {
        Country country = new Country();
        countryList.add(country);
        return country;
    }

    public Country searchCountryById(int id) {
        for (Country country : countryList) {
            if (country.getId() == id) {
                return country;
            }
        }
        return null;
    }

    public void removeCountry(Country country) {
        countryList.remove(country);
    }

}
