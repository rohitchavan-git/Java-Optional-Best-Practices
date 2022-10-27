package com.rohit;

public class Address {
    private final String state;
    private final String city;
    private final int pincode;

    public Address(String state, String city, int pincode) {
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public int getPincode() {
        return pincode;
    }
}
