/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.message;
import business.organization.Organization;
import business.useraccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raseswaridas
 */
public class Message extends Organization {
    
    private static int count = 0;
    private int id;
    
    public enum messageType{
        Message,
        Query,
        WorkOrder;
    };
    
    public enum statusType{
        Open,
        Delivered,
        InProgressWithVendor,
        InProgressWithMaintenance,
        Completed;
    };
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String subject;
    private statusType status;
    private Date requestDate;
    private Date resolveDate;
    private messageType type;
    
    public Message(messageType type, UserAccount sender, UserAccount receiver, statusType status, String message, String subject, Date created){
        super(organizationType.Message);
        count++;
        id = count;
        requestDate = new Date();
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
        this.message = message;
        this.subject = subject;
        this.requestDate = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public statusType getStatus() {
        return status;
    }

    public void setStatus(statusType status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public messageType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }
    
    @Override
    public String toString(){
        return Integer.toString(id);
    }
}
