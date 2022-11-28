/*
 * Author : Pinky Sodhi
 * Date : 28-11-2022
 * Created Using : IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Salesperson{" +
                "salesId=" + salesId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", commissionRate=" + commissionRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesperson)) return false;
        Salesperson that = (Salesperson) o;
        return getSalesId() == that.getSalesId() && Double.compare(that.getCommissionRate(), getCommissionRate()) == 0 && Objects.equals(getName(), that.getName()) && Objects.equals(getCity(), that.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalesId(), getName(), getCity(), getCommissionRate());
    }
}
