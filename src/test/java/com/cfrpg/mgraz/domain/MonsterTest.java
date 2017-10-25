package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.exception.DeadException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class MonsterTest {

    private Monster createMonster(){
        return new Monster("mtest", 100, 7, 50);
    }

    @Test
    public void creation(){
        Monster monster = this.createMonster();

        assertEquals("mtest", monster.getName());
        assertEquals(Integer.valueOf(100), monster.getHealth());
        assertEquals(monster.getHealth(), monster.getMaxHealth());
        assertEquals(Integer.valueOf(7), monster.doDamage());
        assertEquals(Integer.valueOf(50), monster.getXpReward());
        assertEquals(Integer.valueOf(7), monster.doDamage());
    }

    @Test
    public void getHurt(){
        Monster monster = this.createMonster();

        assertEquals(Integer.valueOf(100), monster.getHealth());
        try{
            monster.receiveDamage(50);
            assertEquals(Integer.valueOf(50), monster.getHealth());
        }catch (DeadException e){
            fail();
        }
    }

    @Test
    public void getKill(){
        Monster monster = this.createMonster();

        assertEquals(Integer.valueOf(100), monster.getHealth());
        try{
            monster.receiveDamage(50);
            monster.receiveDamage(51);
            fail();
        }catch (DeadException e){

        }
    }
}
