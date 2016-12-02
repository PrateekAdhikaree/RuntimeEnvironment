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
    
    public enum messageType{
        Message("Message"),
        WorkOrder("Work Order");
    
        private String value;
        private messageType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    };
    
    public enum statusType{
        Open("Open"),
        InProgressWithVendor("In Progress With Vendor"),
        InProgressWithMaintenance("In Progress With Maintenance"),
        Completed("Completed");
    
        private String value;
        private statusType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    };
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String type;
    
    public Message(messageType type, UserAccount sender, UserAccount receiver, statusType status, String message){
        requestDate = new Date();
        this.type = type.getValue();
        this.sender = sender;
        this.receiver = receiver;
        this.status = status.getValue();
        this.message = message;
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

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public String getType() {
        return type;
    }
}
