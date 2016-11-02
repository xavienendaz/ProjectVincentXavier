package com.example.xavier.projectvincentxavier;

/**
 * Created by Xavier on 01.11.2016.
 */

public class DataProviderQuestion {

    private int id;
    private String topic;
    private String title;
    private String content;
    private String username;

    public DataProviderQuestion(int id, String topic, String title, String content, String username){
        this.id=id;
        this.topic=topic;
        this.title=title;
        this.content=content;
        this.username=username;
    }

    public DataProviderQuestion(String topic, String title, String content, String username){
        this.topic=topic;
        this.title=title;
        this.content=content;
        this.username=username;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTopic() {return topic;}

    public void setTopic(String topic) {this.topic = topic;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}
}
