package com.cfrpg.mgraz.controller;

import com.cfrpg.mgraz.domain.character.Character;
import com.cfrpg.mgraz.domain.character.Mage;
import com.cfrpg.mgraz.domain.character.Warrior;
import com.cfrpg.mgraz.provider.CharacterProvider;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class CharacterController {

    private static CharacterController instance;

    private CharacterController(){

    }

    public static CharacterController getInstance(){
        if(instance == null){
            instance = new CharacterController();
        }
        return instance;
    }

    public void startCharacter(){
        System.out.print("Please select a character name: ");
        Scanner scanIn = new Scanner(System.in);
        String characterName = scanIn.nextLine();

        if(!CharacterProvider.getInstance().existCharacter(characterName)){
            createCharacter(characterName);
        }
    }

    private void createCharacter(String characterName){
        boolean created = false;
        do{
            System.out.println("---------------------------------------------------------");
            System.out.println("Please select a character class: ");
            System.out.println("w - Warrior");
            System.out.println("m - Mage");
            System.out.println("x - Exit");
            System.out.print("Choice: ");

            Scanner scanIn = new Scanner(System.in);
            String classOption = scanIn.nextLine();
            System.out.println("---------------------------------------------------------");

            if(classOption.equals("x")){
                System.out.println("Thanks for playing Console Fantasy RPG");
                System.out.println("See you soon!!!");
                System.exit(0);
            }
            if(classOption.equals("w")){
                CharacterProvider.getInstance().createWarrior(characterName);
                created = true;
            }
            if(classOption.equals("m")){
                CharacterProvider.getInstance().createMage(characterName);
                created = true;
            }
        }while (!created);
    }

    public void printDetail(){
        Character character = CharacterProvider.getInstance().getCharacter();
        System.out.println();
        System.out.println("### Character Information ###");
        System.out.println("---------------------------------------------------------");
        System.out.println("Class: ".concat(character.getClassName()));
        System.out.println("Name: ".concat(character.getName()));
        System.out.println("Level: ".concat(character.getCurrentLevel().toString()));
        System.out.println("Hit Points: ".concat(character.getHealth().toString()));
        System.out.println("Damage: ".concat(character.doDamage().toString()));
        System.out.println("---------------------------------------------------------");

        System.out.println("Press enter to continue");
        Scanner scanIn = new Scanner(System.in);
        scanIn.nextLine();
    }
}
