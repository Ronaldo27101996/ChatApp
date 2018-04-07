package com.example.cr7.model;

import java.io.Serializable;

/**
 * Created by CR7 on 3/9/2018.
 */

public class Conversation implements Serializable{
    private String name;
    private String lastMessage;
    private String image;
    private String date;
    private boolean isOnline;
    public Conversation(){
        super();
    }
    public Conversation(String name, String lastMessage, String image, String date, boolean isOnline) {
        super();
        this.name = name;
        this.lastMessage = lastMessage;
        this.image = image;
        this.date = date;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
