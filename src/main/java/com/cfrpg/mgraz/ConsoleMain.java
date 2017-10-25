package com.cfrpg.mgraz;

import com.cfrpg.mgraz.controller.CharacterController;
import com.cfrpg.mgraz.controller.LocationController;
import com.cfrpg.mgraz.provider.CharacterProvider;
import com.cfrpg.mgraz.provider.LocationProvider;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class ConsoleMain {

    public static void main(String[] args) {
        //Game parameters
        InitialInformation.monsters();
        InitialInformation.locations();

        //Start game
        System.out.println();
        System.out.println();
        System.out.println( "██████╗ ██████╗ ███╗   ██╗███████╗ ██████╗ ██╗     ███████╗    ███████╗ █████╗ ███╗   ██╗████████╗ █████╗ ███████╗██╗   ██╗    ██████╗ ██████╗  ██████╗ \n" +
                            "██╔════╝██╔═══██╗████╗  ██║██╔════╝██╔═══██╗██║     ██╔════╝    ██╔════╝██╔══██╗████╗  ██║╚══██╔══╝██╔══██╗██╔════╝╚██╗ ██╔╝    ██╔══██╗██╔══██╗██╔════╝ \n" +
                            "██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     █████╗      █████╗  ███████║██╔██╗ ██║   ██║   ███████║███████╗ ╚████╔╝     ██████╔╝██████╔╝██║  ███╗\n" +
                            "██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██╔══╝      ██╔══╝  ██╔══██║██║╚██╗██║   ██║   ██╔══██║╚════██║  ╚██╔╝      ██╔══██╗██╔═══╝ ██║   ██║\n" +
                            "╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗███████╗    ██║     ██║  ██║██║ ╚████║   ██║   ██║  ██║███████║   ██║       ██║  ██║██║     ╚██████╔╝\n" +
                            " ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚══════╝    ╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝   ╚═╝  ╚═╝╚══════╝   ╚═╝       ╚═╝  ╚═╝╚═╝      ╚═════╝ ");
        System.out.println();

        //Character selection - Creation
        CharacterController.getInstance().startCharacter();

        CharacterController.getInstance().printDetail();

        //Story
        boolean endStory = false;
        do{
            endStory = LocationController.getInstance().travel();
        }while(!endStory);

        //SAVE GAME
        try{
            CharacterProvider.getInstance().saveCharacter();
            LocationProvider.getInstance().saveLocation();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
