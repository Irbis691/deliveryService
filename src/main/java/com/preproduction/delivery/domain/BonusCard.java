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
@Table(name = "bonus_card")
public class BonusCard implements Serializable {
    
    private static final Double BONUS_PERCENT = 0.1;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "card_id")
    private Integer id;
    @Column(name = "bonus_size")
    private Double bonusSize;

    public BonusCard() {
    }
    
    public BonusCard(Double bonusSize) {                
        this.bonusSize = bonusSize;
    }   

    public BonusCard(Integer id, Double bonusSize) {
        this.id = id;        
        this.bonusSize = bonusSize;
    }        
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBonusSize() {
        return bonusSize * BONUS_PERCENT;
    }

    public void increaseBonusSize(Double bonusSize) {
        this.bonusSize += bonusSize;
    }

    @Override
    public String toString() {
        return "BonusCard{" + "id=" + id + ", bonusSize=" + getBonusSize() + '}';
    }    
        
}
