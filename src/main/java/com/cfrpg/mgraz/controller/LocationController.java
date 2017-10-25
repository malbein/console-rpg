package com.cfrpg.mgraz.controller;

import com.cfrpg.mgraz.provider.CharacterProvider;
import com.cfrpg.mgraz.provider.LocationProvider;
import com.cfrpg.mgraz.domain.location.Location;

import java.util.Scanner;

/**
 * Created by mgraz1 on 10/22/17.
 *
 * This is a presentation class that shows the locations
 */
public class LocationController {

    private static LocationController instance;

    private LocationController(){

    }

    public static LocationController getInstance(){
        if(instance == null){
            instance = new LocationController();
        }
        return instance;
    }

    public boolean travel(){
        boolean alive = true;
        boolean finish = false;
        do{
            System.out.println();
            Location location = LocationProvider.getInstance().getCurrentLocation();
            System.out.println("---------------------------------------------------------");
            System.out.println("You arrive to: ".concat(location.getName()));
            System.out.println("---------------------------------------------------------");
            System.out.println(location.getIntro());
            System.out.println("---------------------------------------------------------");
            System.out.println("Choice an option");
            location.actionOptions().forEach(action->{
                System.out.println(action);
            });

            if(location.getPrevius() != null){
                System.out.println("return - return to ".concat(location.getPrevius().getName()));
            }
            if(location.getNext() != null){
                System.out.println("move - move to ".concat(location.getNext().getName()));
            }
            System.out.println("exit - Save and Exit game");
            System.out.print("Choice: ");

            Scanner scanIn = new Scanner(System.in);
            String option = scanIn.nextLine();

            if(option.equals("exit")){
                System.out.println("Thanks for playing Console Fantasy RPG");
                System.out.println("See you soon!!!");
                finish = true;
                alive = false;
            }
            if(location.getPrevius() != null && option.equals("return")){
                LocationProvider.getInstance().movePreviousLocation();
            }
            if(location.getNext() != null && option.equals("move")){
                LocationProvider.getInstance().moveNextLocation();
            }

            //Attack has been choice
            if(option.equals("attack")){
                alive = BattleController.getInstance().match(location);
            }

            //Rest has been choice
            if(option.equals("rest")){
                System.out.println("---------------------------------------------------------");
                System.out.println("ZZZZ....");
                System.out.println("ZZZZZZZZZ......");
                System.out.println("ZZZZZZZZZZZZZZZZ.....");
                System.out.println("You spend the night sleeping and get back all your health");
                System.out.println("---------------------------------------------------------");
                CharacterProvider.getInstance().getCharacter().rest();
                CharacterController.getInstance().printDetail();
            }
        }while(alive);

        return finish;
    }

}
