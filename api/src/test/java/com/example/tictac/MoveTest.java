package com.example.tictac;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {
    private Move aMove = new Move(1, 2, 3, "HelloWorld");
    private Move aMove2 = new Move(1, 2, 3, "HelloWorld");
    private Move aMove3 = new Move(1, 2, 3, "HelloMSH");

    @Test
    public void testMove(){
        assertTrue(aMove.getId() == 1);
    }

    @Test
    public void testMove2(){
        assertTrue(aMove.getPlayer() == 3);
    }

    @Test
    public void testMove3(){
        assertTrue(aMove.getMoveSpot() == 2);
    }

    @Test
    public void testMove4(){
        assertTrue(aMove.getMessage() == "HelloWorld");
    }

    @Test
    public void testMove5() { assertTrue(aMove.equals(aMove2)); }

    @Test
    public void testMove6() {  assertTrue(!aMove.equals(aMove3)); }

    @Test
    public void testMove7() { assertTrue(aMove3.toString() == "HelloMSH"); }

}