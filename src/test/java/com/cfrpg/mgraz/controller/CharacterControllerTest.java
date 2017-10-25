package com.cfrpg.mgraz.controller;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mgraz1 on 10/24/17.
 */
public class CharacterControllerTest {

    @Test
    public void getInstance(){
        CharacterController controller = CharacterController.getInstance();
        assertNotNull(controller);
    }
}
