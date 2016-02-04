/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.domain;

/**
 *
 * @author Irbis
 */
public class Address {
    private Integer id;
    private String street;
    private int houseNum;
    private int flatNum;

    public Address() {
    }

    public Address(Integer id, String street, int houseNum, int flatNum) {
        this.id = id;
        this.street = street;
        this.houseNum = houseNum;
        this.flatNum = flatNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public int getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(int flatNum) {
        this.flatNum = flatNum;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", houseNum=" + houseNum +
                ", flatNum=" + flatNum + '}';
    }        
    
}
