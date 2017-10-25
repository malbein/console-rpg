package com.cfrpg.mgraz.provider;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mgraz1 on 10/24/17.
 */
public class CharacterProviderTest {

    @Test
    public void existCharacter(){
        CharacterProvider.getInstance().existCharacter("Mati");
        assertEquals("Mati", CharacterProvider.getInstance().getCharacter().getName());
    }
}
