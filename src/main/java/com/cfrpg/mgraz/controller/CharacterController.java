package com.cfrpg.mgraz.controller;

import com.cfrpg.mgraz.domain.character.Character;
import com.cfrpg.mgraz.domain.character.Mage;
import com.cfrpg.mgraz.domain.character.Warrior;

import java.util.Scanner;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class CharacterController {

    private static CharacterController instance;
    private Character character;

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

        if(!existCharacter(characterName)){
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
                character = new Warrior(characterName);
                created = true;
            }
            if(classOption.equals("m")){
                character = new Mage(characterName);
                created = true;
            }
        }while (!created);
    }

    public Character getCharacter(){
        return character;
    }

    private boolean existCharacter(String characterName){
        //TODO should check if the character already exist on the app
        return false;
    }

    public void printDetail(){
        System.out.println("Character Information");
        System.out.println("---------------------------------------------------------");
        System.out.println("Class: ".concat(character.getClassName()));
        System.out.println("Name: ".concat(character.getName()));
        System.out.println("Level: ".concat(character.getCurrentLevel().toString()));
        System.out.println("Hit Points: ".concat(character.getHealth().toString()));
        System.out.println("---------------------------------------------------------");
    }
}
