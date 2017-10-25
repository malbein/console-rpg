package com.cfrpg.mgraz.provider;

import com.cfrpg.mgraz.domain.location.Location;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class LocationProvider {

    private static LocationProvider instance;

    private LocationProvider(){

    }

    public static LocationProvider getInstance(){
        if(instance == null){
            instance = new LocationProvider();
        }
        return instance;
    }

    private Map<String,Location> allLocations = new HashMap<String, Location>();
    private Location initialLocation;
    private Location currentLocation;

    public Location getLocation(String name){
        return allLocations.get(name);
    }

    public void addLocation(Location location){
        allLocations.put(location.getName(), location);
    }

    public Location getInitialLocation() {
        return initialLocation;
    }

    public void setInitialLocation(Location initialLocation) {
        this.initialLocation = initialLocation;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void moveNextLocation(){
        currentLocation = currentLocation.getNext();
    }

    public void movePreviousLocation(){
        currentLocation = currentLocation.getPrevius();
    }

    public void saveLocation(){
        try{
            String fileName = CharacterProvider.getInstance().getCharacter().getName().concat(".location.cfrpg");
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(currentLocation.getName());
            fileWriter.close();
        }catch (Exception e){

        }
    }

    public void loadLocation(){
        try{
            String fileName = CharacterProvider.getInstance().getCharacter().getName().concat(".location.cfrpg");
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            String locationName = scanner.nextLine();
            Location location = getLocation(locationName);
            if(location != null){
                currentLocation = location;
            }else{
            }
        }catch (Exception e){
        }
    }
}
