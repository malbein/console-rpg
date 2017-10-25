package com.cfrpg.mgraz.domain.character;

import com.cfrpg.mgraz.domain.Attacker;
import com.cfrpg.mgraz.exception.DeadException;

import java.io.Serializable;

/**
 * Created by mgraz1 on 10/24/17.
 */
public abstract class Role implements Attacker, Serializable {

    private Integer experience = 0;

    private Integer health;

    private Integer currentLevel = 0;

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void gainExperience(Integer experience){
        this.experience += experience;
        Integer newLevel = (this.experience / 10)+1;
        if(this.currentLevel < newLevel){
            this.currentLevel = newLevel;
            this.health = this.getMaxHealth();
        }
    }

    protected Integer getMaxHealth(){
        int hp = this.hpMult();
        return hp*this.getCurrentLevel();
    }

    public Integer getHealth(){
        return health;
    }

    public void receiveDamage(Integer damage) throws DeadException {
        this.health -= damage;
        if(this.health <= 0){
            throw new DeadException();
        }
    }

    public void rest(){
        this.health = this.getMaxHealth();
    }

    public abstract String getClassName();

    public abstract int hpMult();

    public abstract Integer doDamage();
}
