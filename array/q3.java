package array;

import java.util.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class q3 {
    public static int[] solution(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
