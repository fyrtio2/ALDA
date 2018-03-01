import org.junit.*;

public class MySkipListTest {

    MySkipList<Integer> mySkipList = new MySkipList<>(31);

    @Test
    public void loop() {

        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            int lvl = mySkipList.generateLvl();
            if (lvl >= 12) {
                System.out.println(i + ": " + lvl);
                count++;
            }


        }
        System.out.println(count);
    }

}
