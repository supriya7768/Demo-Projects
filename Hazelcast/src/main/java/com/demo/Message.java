package com.demo;

import java.io.Serializable;

public class Message implements Serializable {

    private String id;
    private String content;

    public Message(){}

    public Message(String id, String content){
        this.content = content;
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String getContent(){
        return content;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String toString(){
        return "Message {id = '" + id + " ', content = '" + content + "'}";
    }
}
