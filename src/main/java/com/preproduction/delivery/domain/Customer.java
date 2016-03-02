package com.preproduction.delivery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Integer id;
    @Autowired
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "account_id")
    Account account;
    @Autowired
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "card_id")
    private BonusCard bonusCard;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
    @Autowired
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer() {
    }

    public Customer(Integer id, Account account, BonusCard bonusCard, Address address) {
        this.id = id;
        this.account = account;
        this.bonusCard = bonusCard;
        this.address = address;
    }        

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }      
    
    public BonusCard getBonusCard() {
        return bonusCard;
    }

    public void setBonusCard(BonusCard bonusCard) {
        this.bonusCard = bonusCard;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    } 
        
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for(Order o: orders) {
            str.append(o.toString());
        }
        return "Customer{" + "id=" + id + ", account=" + account + 
                ", bonusCard=" + bonusCard + ", orders=" + str +
                ", address=" + address +'}';
    }
        
}
