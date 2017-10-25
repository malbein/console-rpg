package com.cfrpg.mgraz.provider;

import com.cfrpg.mgraz.InitialInformation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class LocationProviderTest {

    @Test
    public void initiation(){
        InitialInformation.locations();

        assertEquals("City of Beginning", LocationProvider.getInstance().getCurrentLocation().getName());
        assertEquals(LocationProvider.getInstance().getInitialLocation(), LocationProvider.getInstance().getCurrentLocation());
        assertEquals(LocationProvider.getInstance().getLocation(LocationProvider.getInstance().getInitialLocation().getName()), LocationProvider.getInstance().getInitialLocation());
    }

    @Test
    public void moveForward(){
        InitialInformation.locations();
        LocationProvider.getInstance().moveNextLocation();

        assertEquals("Orc Camp", LocationProvider.getInstance().getCurrentLocation().getName());
        assertNotEquals(LocationProvider.getInstance().getInitialLocation(), LocationProvider.getInstance().getCurrentLocation());
        assertEquals(LocationProvider.getInstance().getLocation(LocationProvider.getInstance().getInitialLocation().getName()), LocationProvider.getInstance().getInitialLocation());
    }

    @Test
    public void moveForwardBackward(){
        InitialInformation.locations();
        LocationProvider.getInstance().moveNextLocation();
        LocationProvider.getInstance().movePreviousLocation();

        assertEquals("City of Beginning", LocationProvider.getInstance().getCurrentLocation().getName());
        assertEquals(LocationProvider.getInstance().getInitialLocation(), LocationProvider.getInstance().getCurrentLocation());
        assertEquals(LocationProvider.getInstance().getLocation(LocationProvider.getInstance().getInitialLocation().getName()), LocationProvider.getInstance().getInitialLocation());
    }

    @Test
    public void loadLocation(){
        InitialInformation.locations();
        CharacterProvider.getInstance().createWarrior("Mati");
        LocationProvider.getInstance().loadLocation();
        assertEquals("City of Beginning", LocationProvider.getInstance().getCurrentLocation().getName());
    }

    @Test
    public void cityTest(){
        InitialInformation.locations();

        assertEquals("City of Beginning", LocationProvider.getInstance().getCurrentLocation().getName());
        assertEquals("This is the City of Beginning, you will get back here every time you die. Hope you enjoy your adventure.", LocationProvider.getInstance().getCurrentLocation().getIntro());
        assertEquals(1, LocationProvider.getInstance().getInitialLocation().actionOptions().size());
    }

    @Test
    public void dungeonTest(){
        InitialInformation.locations();
        LocationProvider.getInstance().moveNextLocation();

        assertEquals("Orc Camp", LocationProvider.getInstance().getCurrentLocation().getName());
        assertEquals("You found a camp with a fire, when you look more in detail you see an orc next to the fire.", LocationProvider.getInstance().getCurrentLocation().getIntro());
        assertEquals(1, LocationProvider.getInstance().getCurrentLocation().actionOptions().size());
    }

}