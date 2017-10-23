package com.cfrpg.mgraz.domain.character;

import com.cfrpg.mgraz.domain.Attacker;
import com.cfrpg.mgraz.exception.DeadException;

import java.io.Serializable;

/**
 * Created by mgraz1 on 10/21/17.
 */
public abstract class Character implements Attacker, Serializable{

    private String name;

    private Integer experience = 0;

    private Integer currentLevel = 0;

    private Integer health;

    public Character(String name, Integer experience){
        this.name = name;
        this.gainExperience(experience);
        this.health = this.getMaxHealth();
    }

    public String getName() {
        return name;
    }

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

    public Integer getHealth(){
        return health;
    }

    protected void setHealth(Integer health){
        this.health = health;
    }

    public void receiveDamage(Integer damage) throws DeadException{
        this.health -= damage;
        if(health <= 0){
            throw new DeadException();
        }
    }

    public void rest(){
        this.health = this.getMaxHealth();
    }

    public abstract String getClassName();

    protected abstract Integer getMaxHealth();
}
