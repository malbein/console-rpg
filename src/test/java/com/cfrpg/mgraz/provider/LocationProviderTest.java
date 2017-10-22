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

        assertEquals("Orc Lair", LocationProvider.getInstance().getCurrentLocation().getName());
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
}
