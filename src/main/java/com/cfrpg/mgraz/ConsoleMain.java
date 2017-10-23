package com.cfrpg.mgraz;

import com.cfrpg.mgraz.controller.CharacterController;
import com.cfrpg.mgraz.controller.LocationController;
import com.cfrpg.mgraz.domain.location.Location;

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

        //TODO SAVE GAME
    }
}
