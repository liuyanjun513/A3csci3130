package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Business class.
 */

public class Business implements Serializable{
    private String uid;
    private String number;
    private String name;
    private String businessName;
    private String address;
    private String province;

    public Business(String uid,String name,String number){
        this.uid=uid;
        this.name=name;
        this.number=number;
    }

    public Business(String uid, String number, String name, String businessName, String address, String province) {
        this.uid = uid;
        this.number = number;
        this.name = name;
        this.businessName = businessName;
        this.address = address;
        this.province = province;
    }

    public String getUid(){
        return uid;
    }
    public void setUid(String uid){
        this.uid=uid;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("number", number);

        return result;
    }
}
