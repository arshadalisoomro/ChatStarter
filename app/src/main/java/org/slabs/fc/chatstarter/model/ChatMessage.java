package org.slabs.fc.chatstarter.model;

/**
 * Created by Arshay on 12/18/2016.
 */
public class ChatMessage {
    private String message;
    private String sentAt;

    public ChatMessage(){
        //empty placeholder
    }

    public ChatMessage(String message, String sentAt){
        this.message = message;
        this.sentAt = sentAt;
    }

    public String getMessage() {
        return message;
    }

    public String getSentAt() {
        return sentAt;
    }
}
