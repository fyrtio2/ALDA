

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ClosestPair pairs = new ClosestPair();

        for (int i = 0 ; i < 1000 ; i++) {
            pairs.addPoint(new Point((int) (Math.random() * -10000 + 20000) , (int) (Math.random() * 10000 - 10000/2)));
        }
        System.out.println(pairs.toString());
        System.out.println(pairs.findClosestPair());

    }
}
