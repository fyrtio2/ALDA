

import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ClosestPair pairs = new ClosestPair();
        Random rnd = new Random();
        for (int i = 0 ; i < 50000 ; i++) {
            System.out.println(i);
            pairs.addPoint(new Point(rnd.nextInt(100000) - 50000, rnd.nextInt(100000) - 50000));
        }
        System.out.println(pairs.toString());
        System.out.println(pairs.findClosestPair());

    }
}
