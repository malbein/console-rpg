package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.exception.DeadException;
import com.cfrpg.mgraz.provider.CharacterProvider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class MageTest {

    @Test
    public void creationMage(){
        CharacterProvider.getInstance().createMage("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(5), character.getHealth());
        assertEquals(Integer.valueOf(4), character.doDamage());
    }

    @Test
    public void gainExperienceToLvlUp(){
        CharacterProvider.getInstance().createMage("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        character.gainExperience(90);

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(50), character.getHealth());
    }

    @Test
    public void gainLittleExperience(){
        CharacterProvider.getInstance().createMage("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        character.gainExperience(3);

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(5), character.getHealth());
    }


    @Test
    public void getHurt(){
        CharacterProvider.getInstance().createMage("test");
        Character character = CharacterProvider.getInstance().getCharacter();

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
        CharacterProvider.getInstance().createMage("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        assertEquals(Integer.valueOf(5), character.getHealth());
        try{
            character.receiveDamage(4);
            character.receiveDamage(4);
            fail();
        }catch (DeadException e){

        }
    }

    @Test
    public void getHurtAndXP(){
        CharacterProvider.getInstance().createMage("test");
        Character character = CharacterProvider.getInstance().getCharacter();

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

    @Test
    public void getHurtAndRest(){
        CharacterProvider.getInstance().createMage("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        assertEquals(Integer.valueOf(5), character.getHealth());
        try{
            character.receiveDamage(3);
            assertEquals(Integer.valueOf(2), character.getHealth());
        }catch (DeadException e){
            fail();
        }

        character.rest();

        assertEquals("Mage", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(5), character.getHealth());
    }

}
