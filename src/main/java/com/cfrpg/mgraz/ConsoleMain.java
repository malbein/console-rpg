package com.cfrpg.mgraz;

import com.cfrpg.mgraz.controller.CharacterController;
import com.cfrpg.mgraz.controller.LocationController;
import com.cfrpg.mgraz.domain.character.Character;
import com.cfrpg.mgraz.domain.location.Location;
import com.cfrpg.mgraz.provider.CharacterProvider;
import com.cfrpg.mgraz.provider.LocationProvider;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class ConsoleMain {

    public static void main(String[] args) {
        InitialInformation.monsters();
        InitialInformation.locations();

        System.out.println("Welcome to Console Fantasy RPG");
        CharacterController.getInstance().startCharacter();

        CharacterController.getInstance().printDetail();

        boolean endStory = false;
        do{
            endStory = LocationController.getInstance().travel();
        }while(!endStory);

        try{
            //SAVE GAME
            CharacterProvider.getInstance().saveCharacter();
            LocationProvider.getInstance().saveLocation();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
