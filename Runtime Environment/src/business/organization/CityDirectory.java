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
public class CityDirectory {

    private ArrayList<City> cityList;

    public CityDirectory() {
        cityList = new ArrayList<City>();
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public City addCity() {
        City city = new City();
        cityList.add(city);
        return city;
    }
    
    public City searchCityById(int id){
        for (City city : cityList) {
            if(city.getId() == id){
                return city;
            }
        }
        return null;
    }
    
    public void removeCity(City city){
        cityList.remove(city);
    }

}
