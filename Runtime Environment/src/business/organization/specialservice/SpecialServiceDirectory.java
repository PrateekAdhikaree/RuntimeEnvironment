/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.specialservice;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class SpecialServiceDirectory {
    
    private ArrayList<SpecialService> specialServiceList;
    
    public SpecialServiceDirectory(){
        specialServiceList = new ArrayList<SpecialService>();
    }

    public ArrayList<SpecialService> getSpecialServiceList() {
        return specialServiceList;
    }
    
    public SpecialService addService(){
        SpecialService specialService = new SpecialService();
        specialServiceList.add(specialService);
        return specialService;
    }
    
    public SpecialService searchServicesById(int id){
        for(SpecialService services : specialServiceList){
            if(services.getId() == id){
                return services;
            }
        }
        return null;
    }
    
    public void removeSpecialService(SpecialService specialService){
        specialServiceList.remove(specialService);
    }
    
}
