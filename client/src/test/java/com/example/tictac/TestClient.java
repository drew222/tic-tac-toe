package com.example.tictac;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by drewzoellner on 2/23/16.
 */
public class TestClient {

    TicTacClient client = new TicTacClient("http://localhost:8080");

    @Test
    public void testPOST() {
        Move aMove = client.newTicTacWriteClient().performMove(1, 2);
        assertTrue(aMove.getPlayer() == 1);
        assertTrue(aMove.getMoveSpot() == 2);
    }

    @Test
    public void testGET() {
        Move aMove = client.newTicTacReadClient().retrieveBoard();
        assertTrue(aMove.getPlayer() == -1);
        assertTrue(aMove.getMoveSpot() == -1);
        assertTrue(aMove.getId() == -1);
    }

}
