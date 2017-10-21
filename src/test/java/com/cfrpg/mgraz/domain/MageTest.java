package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.exception.DeadException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class MageTest {

    @Test
    public void creationMage(){
        Character character = new Mage("test");

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(5), character.getHealth());
    }

    @Test
    public void creationXPMage(){
        Character character = new Mage("test", 98);

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(50), character.getHealth());
    }

    @Test
    public void gainExperienceToLvlUp(){
        Character character = new Mage("test");

        character.gainExperience(90);

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(50), character.getHealth());
    }

    @Test
    public void gainLittleExperience(){
        Character character = new Mage("test");

        character.gainExperience(3);

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(5), character.getHealth());
    }


    @Test
    public void getHurt(){
        Character character = new Mage("test");

        assertEquals(Integer.valueOf(5), character.getHealth());
        try{
            character.receiveDamage(3);
            assertEquals(Integer.valueOf(2), character.getHealth());
        }catch (DeadException e){
            fail();
        }
    }

    @Test
    public void getKill(){
        Character character = new Mage("test");

        assertEquals(Integer.valueOf(5), character.getHealth());
        try{
            character.receiveDamage(8);
            fail();
        }catch (DeadException e){

        }
    }

    @Test
    public void getHurtAndXP(){
        Character character = new Mage("test");

        assertEquals(Integer.valueOf(5), character.getHealth());
        try{
            character.receiveDamage(3);
            assertEquals(Integer.valueOf(2), character.getHealth());
        }catch (DeadException e){
            fail();
        }

        character.gainExperience(90);

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(50), character.getHealth());
    }

}
