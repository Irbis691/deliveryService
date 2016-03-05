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
    private Integer houseNumber;
    @Column(name = "flat_number")
    private Integer flatNumber;

    public Address() {
    }

    public Address(Integer id, String street, Integer houseNumber, Integer flatNumber) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
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

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street +
                ", houseNumber=" + houseNumber +
                ", flatNumber=" + flatNumber + '}';
    }
    
}
