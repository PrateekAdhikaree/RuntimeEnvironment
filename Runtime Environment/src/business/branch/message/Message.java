/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.branch.message;

import business.person.useraccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raseswaridas
 */
public class Message {
    
    private UserAccount sender;
    private UserAccount receiver;
    private String message;
    private Date date;
    private int id;
    private static int count = 0;
    
    public Message(){
        count++;
        id = count;
        date = new Date();
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
 
}
