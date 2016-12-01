/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.parentnetwork.ParentNetworkDirectory;
import business.parentnetwork.ParentNetwork;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Skull
 */
public class Initialize {
    
    private FileReader file;
    private BufferedReader reader;
    
    public Business configureBusiness(){
        Business business;
        business = Business.getInstance();
        business = readFromCSV(business);
        return business;
    }
    
    private Business readFromCSV(Business business){
        
        ParentNetworkDirectory parentNetworkDirectory = getParentNetworks();
        
        
        
        return business;
    }
    
    private ParentNetworkDirectory getParentNetworks(){
            
        ParentNetworkDirectory parentNetworkDirectory = new ParentNetworkDirectory();
        
        try {
            this.file = new FileReader("resources/files/ParentNetworkDataset.csv");
            reader = new BufferedReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()+" in getParentNetworks(): Error in reading file").log(Level.SEVERE, null, ex);
        }
        
        try {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) { // reads each line (row) in the CSV
                
                String[] b = line.split(",");
                if(row != 0){
                    ParentNetwork parentNetwork = parentNetworkDirectory.addParentNetwork();
                    parentNetwork.setCountryName(b[0]);
                }
                row++;
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Initialize.class.getName()+" in getParentNetworks()").log(Level.SEVERE, null, ex);
        }
         
        return parentNetworkDirectory;
    }
    
}
