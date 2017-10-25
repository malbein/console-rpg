package com.cfrpg.mgraz.domain.character;

import com.cfrpg.mgraz.domain.Character;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class Warrior extends Role {

    @Override
    public String getClassName() {
        return "Warrior";
    }

    @Override
    public int hpMult() {
        return 10;
    }

    @Override
    public int damagePerLvl() {
        return 4;
    }
}
