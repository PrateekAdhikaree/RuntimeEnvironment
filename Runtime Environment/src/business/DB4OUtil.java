/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author Skull
 */
public class DB4OUtil {

    private ObjectContainer conn;
    
    // For Windows systems
    private static final String FILENAME = "resources\\files\\DB\\DataBank.db4o"; // path to the data store
    // For Mac systems
//     private static final String FILENAME = "resources/files/DB/DataBank.db4o"; // path to the data store
    
    private static DB4OUtil dB4OUtil;

    public synchronized static DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(Business.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    // flag: 0 is while system initialization; 1 is while logout
    public synchronized void storeSystem(Business business, int flag) {
        if(flag == 1)
            conn = createConnection();
        conn.store(business);
        conn.commit();
        if(flag == 1)
            conn.close();
    }

    public Business retrieveSystem() {
        conn = createConnection();
        ObjectSet<Business> system = conn.query(Business.class); // Change to the object you want to save
        Business business;
        if (system.size() == 0) {
            // If there's no Business in the record, create a new one
            Initialize initialize = new Initialize();
            business = initialize.configureBusiness();
            storeSystem(business, 0);
        } else {
            business = system.get(system.size() - 1);
        }
        conn.close();
        return business;
    }
}
