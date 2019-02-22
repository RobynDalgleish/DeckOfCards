package com.robyn.project.cards.v2.standard.war;

import org.junit.Test;

import static org.junit.Assert.*;

public class WarGameTest {
    @Test
    public void testWarGameHasDealer() {
        assertNotNull(new WarGame().getDealer());
    }
}