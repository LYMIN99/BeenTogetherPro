package com.lymin.beentogetherpro.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LoveRealmObject extends RealmObject {

    @PrimaryKey
    private int id;
    private String startDate;
    private String namePerson1;
    private String namePerson2;
    private byte[] profile1;
    private byte[] profile2;

    public LoveRealmObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getNamePerson1() {
        return namePerson1;
    }

    public void setNamePerson1(String namePerson1) {
        this.namePerson1 = namePerson1;
    }

    public String getNamePerson2() {
        return namePerson2;
    }

    public void setNamePerson2(String namePerson2) {
        this.namePerson2 = namePerson2;
    }

    public byte[] getProfile1() {
        return profile1;
    }

    public void setProfile1(byte[] profile1) {
        this.profile1 = profile1;
    }

    public byte[] getProfile2() {
        return profile2;
    }

    public void setProfile2(byte[] profile2) {
        this.profile2 = profile2;
    }
}
