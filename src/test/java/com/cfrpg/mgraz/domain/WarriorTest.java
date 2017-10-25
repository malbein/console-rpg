package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.exception.DeadException;
import com.cfrpg.mgraz.provider.CharacterProvider;
import com.cfrpg.mgraz.provider.CharacterProviderTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class WarriorTest {

    @Test
    public void creationWarrior(){
        CharacterProvider.getInstance().createWarrior("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(10), character.getHealth());
        assertEquals(Integer.valueOf(4), character.doDamage());
    }

    @Test
    public void gainExperienceToLvlUp(){
        CharacterProvider.getInstance().createWarrior("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        character.gainExperience(90);

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(10), character.getCurrentLevel());
        assertEquals(Integer.valueOf(100), character.getHealth());
    }

    @Test
    public void gainLittleExperience(){
        CharacterProvider.getInstance().createWarrior("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        character.gainExperience(6);

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(10), character.getHealth());
    }


    @Test
    public void getHurt(){
        CharacterProvider.getInstance().createWarrior("test");
        Character character = CharacterProvider.getInstance().getCharacter();

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
        CharacterProvider.getInstance().createWarrior("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        assertEquals(Integer.valueOf(10), character.getHealth());
        try{
            character.receiveDamage(6);
            character.receiveDamage(6);
            fail();
        }catch (DeadException e){

        }
    }

    @Test
    public void getHurtAndXP(){
        CharacterProvider.getInstance().createWarrior("test");
        Character character = CharacterProvider.getInstance().getCharacter();

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

    @Test
    public void getHurtAndRest(){
        CharacterProvider.getInstance().createWarrior("test");
        Character character = CharacterProvider.getInstance().getCharacter();

        assertEquals(Integer.valueOf(10), character.getHealth());
        try{
            character.receiveDamage(5);
            assertEquals(Integer.valueOf(5), character.getHealth());
        }catch (DeadException e){
            fail();
        }

        character.rest();

        assertEquals("Warrior", character.getClassName());
        assertEquals("test", character.getName());
        assertEquals(Integer.valueOf(1), character.getCurrentLevel());
        assertEquals(Integer.valueOf(10), character.getHealth());
    }
}
