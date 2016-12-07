/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.parentnetwork;

import business.network.NetworkDirectory;

/**
 *
 * @author raseswaridas
 */
public class ParentNetwork {
    
    private String countryName;
    private int id;
    private float currencyMultiplier;
    private String currency;
    private static int count = 0;
    private NetworkDirectory networkDirectory;
    
    public ParentNetwork(String currency, float currencyMultiplier){
        count++;
        id = count;
        this.currency = currency;
        this.currencyMultiplier = currencyMultiplier;
    }

    public int getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }

    public float getCurrencyMultiplier() {
        return currencyMultiplier;
    }

    public String getCurrency() {
        return currency;
    }
    
}
