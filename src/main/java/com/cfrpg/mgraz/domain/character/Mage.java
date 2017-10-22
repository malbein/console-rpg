package com.cfrpg.mgraz.domain.character;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class Mage extends Character{

    public Mage(String name, Integer experience){
        super(name, experience);
    }

    public Mage(String name){
        super(name, 0);
    }

    protected Integer getMaxHealth(){
        return 5*super.getCurrentLevel();
    }

    public String getClassName() {
        return "Mage";
    }

    public String[] getActionList() {
        return new String[] {"arcane bolt"};
    }

    public void doAction(String action) {

    }
}