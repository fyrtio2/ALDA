

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ClosestPair pairs = new ClosestPair();

        for (int i = 0 ; i < 2000 ; i++) {
            pairs.addPoint(new Point((int) (Math.random() * 10000), (int) (Math.random() * 10000)));
        }
        System.out.println(pairs.toString());
        System.out.println(pairs.findClosestPair());

    }
}
