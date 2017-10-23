package com.cfrpg.mgraz.provider;

import com.cfrpg.mgraz.domain.character.Character;
import com.cfrpg.mgraz.domain.character.Mage;
import com.cfrpg.mgraz.domain.character.Warrior;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class CharacterProvider {

    private static CharacterProvider instance;

    private CharacterProvider(){

    }

    public static CharacterProvider getInstance(){
        if(instance == null){
            instance = new CharacterProvider();
        }
        return instance;
    }

    private Character character;

    public boolean existCharacter(String characterName){
        boolean found = false;
        try{
            String fileName = characterName.concat(".char.cfrpg");
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            character = (Character) ois.readObject();
            ois.close();
            found = true;
            System.out.println("###### Character found ######");
        }catch (Exception e){
            System.out.println("···· CHARACTER NOT LOADED ······");
        }
        LocationProvider.getInstance().loadLocation();

        return found;
    }

    public Character getCharacter(){
        return character;
    }

    public void createWarrior(String characterName){
        character = new Warrior(characterName);
    }

    public void createMage(String characterName){
        character = new Mage(characterName);
    }

    public void saveCharacter() throws Exception{
        String fileName = character.getName().concat(".char.cfrpg");
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(character);
        oos.close();
    }
}
