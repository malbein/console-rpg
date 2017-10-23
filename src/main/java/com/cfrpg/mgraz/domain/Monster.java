package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.exception.DeadException;
import com.cfrpg.mgraz.exception.MonsterDeadException;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class Monster implements Attacker{

    private String name;
    private Integer health;
    private Integer maxHealth;
    private Integer damage;
    private Integer xpReward;

    public Monster(String name, Integer maxHealth, Integer damage, Integer xpReward){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = this.maxHealth;
        this.damage = damage;
        this.xpReward = xpReward;
    }

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public Integer getXpReward() {
        return xpReward;
    }

    public void receiveDamage(Integer damage) throws MonsterDeadException {
        this.health -= damage;
        if(health <= 0){
            throw new MonsterDeadException();
        }
    }

    public Integer doDamage() {
        return damage;
    }

    public void reset(){
        this.health = this.maxHealth;
    }
}
