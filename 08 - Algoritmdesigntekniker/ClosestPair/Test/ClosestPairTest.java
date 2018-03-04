import org.junit.Test;

import java.awt.*;
import java.util.*;

import static org.junit.Assert.*;

public class ClosestPairTest {

    @Test
    public void testMinMaxValue() {
        ClosestPair pairs = new ClosestPair();
        pairs.addPoint(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE));
        pairs.addPoint(new Point(Integer.MIN_VALUE, 2389));
        pairs.addPoint(new Point(30, Integer.MAX_VALUE));
        pairs.addPoint(new Point(1, Integer.MAX_VALUE));

        assertEquals(pairs.findClosestPair(0,pairs.getSize()-1), pairs.findClosestPair(), 0.00);
        System.out.println(pairs.toString());
        System.out.println(pairs.findClosestPair());
    }


    @Test
    public void TestRandom()
    {
        ClosestPair pairs = new ClosestPair();
        Random rd = new Random();

        for (int i = 0 ; i < 100 ; i++) {
            pairs.addPoint(new Point(rd.nextInt(1000) , rd.nextInt(1000)));
        }

        assertEquals(pairs.findClosestPair(0,pairs.getSize()-1), pairs.findClosestPair(), 0.00);
        System.out.println(pairs.toString());
        System.out.println(pairs.findClosestPair());
    }


}