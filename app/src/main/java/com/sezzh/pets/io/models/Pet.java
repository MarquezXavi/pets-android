package com.sezzh.pets.io.models;

/**
 * Created by sezzh on 26/09/16.
 */
public class Pet {

    private int id;
    private String name;
    private String avatar;

    public Pet() {

    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
