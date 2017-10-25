package com.cfrpg.mgraz.domain.location;

import com.cfrpg.mgraz.domain.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class Dungeon extends Location {

    private Monster monster;

    public List<String> actionOptions(){
        List<String> list = new ArrayList<String>();
        list.add("attack - Engage in battle");
        return list;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
