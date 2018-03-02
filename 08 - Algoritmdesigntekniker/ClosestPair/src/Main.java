

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ClosestPair pairs = new ClosestPair();

        for (int i = 0 ; i < 20 ; i++) {
            pairs.addPoint(new Point((int) (Math.random() * 10000), (int) (Math.random() * 10000)));
        }
        System.out.println(pairs.findClosestPair());

        System.out.println(pairs.toString());
    }
}
