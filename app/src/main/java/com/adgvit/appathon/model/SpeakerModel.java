package com.adgvit.appathon.model;

public class SpeakerModel {
    String picture;
    String name;
    String description;
    String link;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SpeakerModel(String picture, String name, String speakerDesignation, String link) {
        this.picture = picture;
        this.name = name;
        this.description = speakerDesignation;
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeakerDesignation() {
        return description;
    }

    public void setSpeakerDesignation(String speakerDesignation) {
        this.description = speakerDesignation;
    }

    public SpeakerModel(){

    }
}
