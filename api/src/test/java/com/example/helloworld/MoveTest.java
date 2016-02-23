package com.example.helloworld;

import org.junit.Test;
import org.junit.Assert.*;
import java.util.*;

public class MoveTest {
    private Move aMove = new Move(1, 2, 3, "HelloWorld");

    @Test
    public void testMove(){
        assert(aMove.getId() == 1);
    }

    @Test
    public void testMove2(){
        assert(aMove.getPlayer() == 3);
    }

    @Test
    public void testMove3(){
        assert(aMove.getMoveSpot() == 2);
    }

    @Test
    public void testMove4(){
        assert(aMove.getMessage() == "HelloWorld");
    }
}