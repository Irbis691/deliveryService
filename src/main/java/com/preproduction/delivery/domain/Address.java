/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private int houseNum;
    @Column(name = "flat_number")
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
        return "Address{" + "id=" + id + ", street=" + street + ", houseNum=" +
                houseNum + ", flatNum=" + flatNum + '}';
    }    
    
}
