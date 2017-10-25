package com.cfrpg.mgraz.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mgraz1 on 10/24/17.
 */
public class BattleControllerTest {

    @Test
    public void getInstance(){
        BattleController controller = BattleController.getInstance();
        assertNotNull(controller);
    }
}
