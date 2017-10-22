package com.cfrpg.mgraz.controller;

import com.cfrpg.mgraz.provider.LocationProvider;
import com.cfrpg.mgraz.domain.location.Location;

import java.util.Scanner;

/**
 * Created by mgraz1 on 10/22/17.
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
            Location location = LocationProvider.getInstance().getCurrentLocation();
            System.out.println("---------------------------------------------------------");
            System.out.println("You arrive to: ".concat(location.getName()));
            System.out.println("---------------------------------------------------------");
            System.out.println(location.getIntro());
            System.out.println("---------------------------------------------------------");
            System.out.println("Choice an option");
            if(location.getPrevius() != null){
                System.out.println("r - return to ".concat(location.getPrevius().getName()));
            }
            if(location.getNext() != null){
                System.out.println("n - move to ".concat(location.getNext().getName()));
            }
            System.out.println("x - Exit");
            System.out.print("Choice: ");

            Scanner scanIn = new Scanner(System.in);
            String option = scanIn.nextLine();

            if(option.equals("x")){
                System.out.println("Thanks for playing Console Fantasy RPG");
                System.out.println("See you soon!!!");
                finish = true;
                alive = false;
            }
            if(location.getPrevius() != null && option.equals("r")){
                LocationProvider.getInstance().movePreviousLocation();
            }
            if(location.getNext() != null && option.equals("n")){
                LocationProvider.getInstance().moveNextLocation();
            }

        }while(alive);

        return finish;
    }
}
