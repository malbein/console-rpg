package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.exception.DeadException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class WarriorTest {

    @Test
    public void creationWarrior(){
        Character character = new Warrior("test");

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(10), character.getHealth());
    }

    @Test
    public void creationXPWarrior(){
        Character character = new Warrior("test", 98);

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(100), character.getHealth());
    }

    @Test
    public void gainExperienceToLvlUp(){
        Character character = new Warrior("test");

        character.gainExperience(90);

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(100), character.getHealth());
    }

    @Test
    public void gainLittleExperience(){
        Character character = new Warrior("test");

        character.gainExperience(6);

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(10), character.getHealth());
    }


    @Test
    public void getHurt(){
        Character character = new Warrior("test");

        assertEquals(Integer.valueOf(10), character.getHealth());
        try{
            character.receiveDamage(5);
            assertEquals(Integer.valueOf(5), character.getHealth());
        }catch (DeadException e){
            fail();
        }
    }

    @Test
    public void getKill(){
        Character character = new Warrior("test");

        assertEquals(Integer.valueOf(10), character.getHealth());
        try{
            character.receiveDamage(15);
            fail();
        }catch (DeadException e){

        }
    }

    @Test
    public void getHurtAndXP(){
        Character character = new Warrior("test");

        assertEquals(Integer.valueOf(10), character.getHealth());
        try{
            character.receiveDamage(5);
            assertEquals(Integer.valueOf(5), character.getHealth());
        }catch (DeadException e){
            fail();
        }

        character.gainExperience(90);

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(100), character.getHealth());
    }

}
