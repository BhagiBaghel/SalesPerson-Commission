/*
 * Author : Pinky Sodhi
 * Date : 28-11-2022
 * Created Using : IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

public class Salesperson {
    private int salesId;
    private String name;
    private String city;
    private double commissionRate;

    public Salesperson() {
    }

    public Salesperson(int salesId, String name, String city, double commissionRate) {
        this.salesId = salesId;
        this.name = name;
        this.city = city;
        this.commissionRate = commissionRate;
    }

    public int getSalesId() {
        return salesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
