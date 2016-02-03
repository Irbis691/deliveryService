package com.preproduction.delivery.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Mantixop on 1/21/16.
 */

public class Customer {
    private int id;
    private String name;
    @Autowired
    private Address address;
    @Autowired
    private BonusCard bonusCard;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }        

    public Customer(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    } 

    public Customer(int id, String name, Address address, BonusCard bonusCard) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bonusCard = bonusCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BonusCard getBonusCard() {
        return bonusCard;
    }

    public void setBonusCard(BonusCard bonusCard) {
        this.bonusCard = bonusCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }   
    
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name +
                ", address=" + address + ", bonusCard=" + bonusCard + '}';
    }        
    
}
