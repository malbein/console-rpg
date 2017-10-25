package com.cfrpg.mgraz.domain.character;

import com.cfrpg.mgraz.domain.Character;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class Mage extends Role {

    @Override
    public String getClassName() {
        return "Mage";
    }

    @Override
    public int hpMult() {
        return 5;
    }

    @Override
    public int damagePerLvl() {
        return 3;
    }
}