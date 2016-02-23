package com.example.helloworld;

        import org.junit.Test;
        import org.junit.Assert.*;
        import java.util.*;
        import retrofit.*;
/**
 * Created by drewzoellner on 2/23/16.
 */
public class TestClient {

    TicTacClient client = new TicTacClient("http://localhost:8080");

    @Test
    public void testPOST() {
        Move aMove = client.newTicTacWriteClient().performMove(1, 2);
        assert(aMove.getPlayer() == 1);
        assert(aMove.getMoveSpot() == 2);
    }

    @Test
    public void testGET() {
        Move aMove = client.newTicTacReadClient().retrieveBoard();
        assert(aMove.getPlayer() == -1);
        assert(aMove.getMoveSpot() == -1);
        assert(aMove.getId() == -1);
    }

}
