package test;

import java.util.ArrayList;
import java.util.List;

public class testlist {
    List<Integer> list = new ArrayList<>();

    public void def() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
