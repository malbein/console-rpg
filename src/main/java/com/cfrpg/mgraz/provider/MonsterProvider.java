package com.cfrpg.mgraz.provider;

import com.cfrpg.mgraz.domain.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class MonsterProvider {

    private static MonsterProvider instance;

    private MonsterProvider(){

    }

    public static MonsterProvider getInstance(){
        if(instance == null){
            instance = new MonsterProvider();
        }
        return instance;
    }

    private Map<String,Monster> monsters = new HashMap<String, Monster>();

    public void addMonster(Monster monster){
        monsters.put(monster.getName(), monster);
    }

    public Monster getMonster(String name){
        return monsters.get(name);
    }
}
