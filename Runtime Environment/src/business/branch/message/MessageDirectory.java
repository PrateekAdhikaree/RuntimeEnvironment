/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.branch.message;

import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class MessageDirectory {
    
    private ArrayList<Message> messageList;
    
    public MessageDirectory(){
        messageList = new ArrayList<Message>();
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }
    
    public Message addMessage(){
        Message message = new Message();
        messageList.add(message);
        return message;
    }
    
    public Message searchMessageById(int id){
        for(Message message : messageList){
            if(message.getId() == id){
                return message;
            }
        }
        return null;
    }
    
    public void removeMessage(Message message){
        messageList.remove(message);
    }
    
}
