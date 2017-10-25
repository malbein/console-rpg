package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.domain.character.Role;
import com.cfrpg.mgraz.exception.DeadException;

import java.io.Serializable;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class Character implements Attacker, Serializable{

    private Role role;

    private String name;

    public Character(String name, Integer experience, Role role){
        this.name = name;
        this.role = role;
        role.gainExperience(experience);
        role.rest();
    }

    public String getName() {
        return name;
    }

    public void receiveDamage(Integer damage) throws DeadException{
        role.receiveDamage(damage);
    }

    public void rest(){
        role.rest();
    }

    public String getClassName(){
        return role.getClassName();
    };

    public Integer doDamage(){
        return role.doDamage();
    }

    public Integer getCurrentLevel() {
        return role.getCurrentLevel();
    }

    public Integer getHealth() {
        return role.getHealth();
    }

    public void gainExperience(Integer xpReward) {
        role.gainExperience(xpReward);
    }
}
