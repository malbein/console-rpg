package com.cfrpg.mgraz.domain;

import java.util.List;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class Warrior extends Character{

    public Warrior(String name, Integer experience){
        super(name, experience);
    }

    public Warrior(String name){
        super(name, 0);
    }

    protected Integer getMaxHealth(){
        return 10*super.getCurrentLevel();
    }

    public String getClassName() {
        return "Warrior";
    }

    public String[] getActionList() {
        return new String[] {"sword attack"};
    }

    public void doAction(String action) {

    }
}
