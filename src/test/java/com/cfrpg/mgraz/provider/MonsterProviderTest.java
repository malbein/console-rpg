package com.cfrpg.mgraz.provider;

import com.cfrpg.mgraz.InitialInformation;
import com.cfrpg.mgraz.domain.Monster;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mgraz1 on 10/23/17.
 */
public class MonsterProviderTest {

    @Test
    public void initiation(){
        InitialInformation.monsters();

       assertEquals("Red Dragon", MonsterProvider.getInstance().getMonster("Red Dragon").getName());
    }

    @Test
    public void addMonster(){
        String monsterName = "test";
        MonsterProvider provider = MonsterProvider.getInstance();
        provider.addMonster(new Monster(monsterName, 2, 1, 3));

        assertEquals(monsterName, MonsterProvider.getInstance().getMonster(monsterName).getName());
    }
}
