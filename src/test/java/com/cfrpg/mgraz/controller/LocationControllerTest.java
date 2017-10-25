package com.cfrpg.mgraz.controller;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mgraz1 on 10/24/17.
 */
public class LocationControllerTest {

    @Test
    public void getInstance(){
        LocationController controller = LocationController.getInstance();
        assertNotNull(controller);
    }
}
