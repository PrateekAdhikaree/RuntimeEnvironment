/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class NetworkDirectory {

    private ArrayList<Network> networkList;

    public NetworkDirectory() {
        networkList = new ArrayList<Network>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network addNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
    public Network searchNetworkById(int id){
        for (Network network : networkList) {
            if(network.getId() == id){
                return network;
            }
        }
        return null;
    }
    
    public void removeNetwork(Network network){
        networkList.remove(network);
    }

}
