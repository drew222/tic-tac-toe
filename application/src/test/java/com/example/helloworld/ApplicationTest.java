package com.example.helloworld;

import org.junit.Test;
import org.junit.Assert.*;
import java.util.*;

public class ApplicationTest {

    @Test
    public void testBoardCreation() {
        HelloWorldResource aResource = new HelloWorldResource(new ArrayList<Integer>(), "9");
        assert(aResource.board.size() == 9);
    }

    @Test
    public void testBoardMove(){
        HelloWorldResource aResource = new HelloWorldResource(new ArrayList<Integer>(), "9");
        aResource.performMove(1,1);
        assert(aResource.board.get(0) == 1);
        assert(aResource.board.get(1) == 0);
    }

}