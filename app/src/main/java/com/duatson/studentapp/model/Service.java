package com.duatson.studentapp.model;

import java.util.Map;

public class Service {
    private String id;
    private String name;
    private String desctiption;
    private double fee;
    private String icon;
    private Map<String, String> contact;

    public Service() {
        // empty constructor
    }

    public Service(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Service(String id, String name, String desctiption, double fee, String icon, Map<String, String> contact) {
        this.id = id;
        this.name = name;
        this.desctiption = desctiption;
        this.fee = fee;
        this.icon = icon;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        //this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, String> getContact() {
        return contact;
    }

    public void setContact(Map<String, String> contact) {
        this.contact = contact;
    }
}
