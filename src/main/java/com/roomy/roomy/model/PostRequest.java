package com.roomy.roomy.model;

import java.util.Date;
import java.util.UUID;

public class PostRequest {
    private UUID userId;
    private String postBody;
    private String gender;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private int rent;
    private int noOfRoommates;
    private int noOfFilledRoommates;
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getnoOfRoommates() {
        return noOfRoommates;
    }

    public void setnoOfRoommates(int noOfRoommates) {
        this.noOfRoommates = noOfRoommates;
    }

    public int getNoOfFilledRoommates() {
        return noOfFilledRoommates;
    }

    public void setNoOfFilledRoommates(int noOfFilledRoommates) {
        this.noOfFilledRoommates = noOfFilledRoommates;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "userId=" + userId +
                ", postBody='" + postBody + '\'' +
                ", gender='" + gender + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                ", rent=" + rent +
                ", noOfRoommates=" + noOfRoommates +
                ", noOfFilledRoommates=" + noOfFilledRoommates +
                '}';
    }
}
