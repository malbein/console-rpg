package com.cfrpg.mgraz;

import com.cfrpg.mgraz.domain.location.City;
import com.cfrpg.mgraz.domain.location.Dungeon;
import com.cfrpg.mgraz.provider.LocationProvider;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class InitialInformation {

    public static void locations(){
        LocationProvider provider = LocationProvider.getInstance();
        City city1 = new City();
        city1.setName("City of Beginning");
        city1.setIntro("This is the City of Beginning, you will get back here every time you die. Hope you enjoy your adventure.");
        provider.addLocation(city1);
        provider.setInitialLocation(city1);

        Dungeon dungeon1 = new Dungeon();
        dungeon1.setName("Orc Lair");
        dungeon1.setIntro("You found a cave with some fire on the end, when you look more in detail you see an orc next to the fire");
        city1.setNext(dungeon1);
        dungeon1.setPrevius(city1);
        provider.addLocation(dungeon1);

        City city2 = new City();
        city2.setName("City of the Dragon");
        city2.setIntro("This is the City of the Dragon, is a small city that rest at the bottom of a vulcan");
        dungeon1.setNext(city2);
        city2.setPrevius(dungeon1);
        provider.addLocation(city2);

        Dungeon dungeon2 = new Dungeon();
        dungeon2.setName("Dragon Lair");
        dungeon2.setIntro("When you get on top of the volcane you see a shadow that eclipse the sun, it's a Red Dragon!!!");
        city2.setNext(dungeon2);
        dungeon2.setPrevius(city2);
        provider.addLocation(dungeon2);

        provider.setCurrentLocation(provider.getInitialLocation());
    }
}
