package com.rohit;

public class Person {
    private final String fname;
    private final String lname;
    private final Address address;

    public Person(String fname, String lname, Address address) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Address getAddress() {
        return address;
    }
}
