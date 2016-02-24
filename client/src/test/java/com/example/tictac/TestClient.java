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
        TicTacWriteClient writer = client.newTicTacWriteClient();
        Game aGame = writer.createGame();
        Move aMove = writer.performMove(aGame.getId(), 1, 2);
        assertTrue(aMove.getPlayer() == 1);
        assertTrue(aMove.getMoveSpot() == 2);
    }

    @Test
    public void testGET() {
        TicTacWriteClient writer = client.newTicTacWriteClient();
        TicTacReadClient reader = client.newTicTacReadClient();
        Game aGame = writer.createGame();
        Move aMove = reader.retrieveBoard(aGame.getId());
        assertTrue(aMove.getPlayer() == -1);
        assertTrue(aMove.getMoveSpot() == -1);
        assertTrue(aMove.getId() == -1);
    }
    

}
