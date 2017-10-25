package com.cfrpg.mgraz.controller;

import com.cfrpg.mgraz.domain.Character;
import com.cfrpg.mgraz.provider.CharacterProvider;

import java.util.Scanner;

/**
 * Created by mgraz1 on 10/22/17.
 *
 * This is a presentation class that shows the character
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

    /**
     * It checks if the character already exist or need to create a new one
     */
    public void startCharacter(){
        String characterName;
        do{
            System.out.print("Please select a character name: ");
            Scanner scanIn = new Scanner(System.in);
            characterName = scanIn.nextLine();
        }while(characterName.isEmpty());

        if(!CharacterProvider.getInstance().existCharacter(characterName)){
            createCharacter(characterName);
        }
    }

    private void createCharacter(String characterName){
        boolean created = false;
        do{
            System.out.println("---------------------------------------------------------");
            System.out.println("Please select a character class: ");
            System.out.println("warrior - Creates a warrior character");
            System.out.println("mage - Creates a mage character");
            System.out.println("exit - Leaves game");
            System.out.print("Choice: ");

            Scanner scanIn = new Scanner(System.in);
            String classOption = scanIn.nextLine();
            System.out.println("---------------------------------------------------------");

            if(classOption.equals("exit")){
                System.out.println("Thanks for playing Console Fantasy RPG");
                System.out.println("See you soon!!!");
                System.exit(0);
            }
            if(classOption.equals("warrior")){
                CharacterProvider.getInstance().createWarrior(characterName);
                created = true;
            }
            if(classOption.equals("mage")){
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
