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
public class BonusCard {
    
    private static final Double BONUS_PERCENT = 0.1;
    
    private Integer id;    
    private Integer bonusSize;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBonusSize() {
        return (int)(bonusSize * BONUS_PERCENT);
    }

    public void increaseBonusSize(Integer bonusSize) {
        this.bonusSize += bonusSize;
    }
    

    @Override
    public String toString() {
        return "BonusCard{" + "id=" + id + ", bonusSize=" + bonusSize + '}';
    }
        
}
