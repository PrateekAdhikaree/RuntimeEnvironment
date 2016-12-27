/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.parentnetwork;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class ParentNetworkDirectory {

    private ArrayList<ParentNetwork> parentNetworkList;

    public ParentNetworkDirectory() {
        parentNetworkList = new ArrayList<ParentNetwork>();
    }

    public ArrayList<ParentNetwork> getParentNetworkList() {
        return parentNetworkList;
    }

    public ParentNetwork addParentNetwork(String currency, float currencyMultiplier) {
        ParentNetwork parentNetwork = new ParentNetwork(currency, currencyMultiplier);
        parentNetworkList.add(parentNetwork);
        return parentNetwork;
    }

    public ParentNetwork searchParentNetworkById(int id) {
        for (ParentNetwork parentNetwork : parentNetworkList) {
            if (parentNetwork.getId() == id) {
                return parentNetwork;
            }
        }
        return null;
    }

    public void removeParentNetwork(ParentNetwork parentNetwork) {
        parentNetworkList.remove(parentNetwork);
    }

}
