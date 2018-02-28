import org.junit.*;

public class MySkipListTest {

    MySkipList<Integer> mySkipList = new MySkipList<>();

    @Test
    public void loop() {
        for (int i = 0; i < 20; i++) {
            System.out.println(mySkipList.randInt());
        }
    }

}
