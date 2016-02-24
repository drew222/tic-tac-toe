package com.example.tictac;

import org.junit.Test;

public class MoveTest {
    private Move aMove = new Move(1, 2, 3, "HelloWorld");
    private Move aMove2 = new Move(1, 2, 3, "HelloWorld");
    private Move aMove3 = new Move(1, 2, 3, "HelloMSH");

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

    @Test
    public void testMove5() { assert(aMove.equals(aMove2)); }

    @Test
    public void testMove6() {  assert(!aMove.equals(aMove3)); }

    @Test
    public void testMove7() { assert(aMove3.toString() == "HelloMSH"); }

}