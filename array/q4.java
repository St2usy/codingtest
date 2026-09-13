package array;

import java.util.*;

public class q4 {
    public static int[] solution(int[] arr) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] arr3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> submit = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr1[i % 5]) {
                cnt1 += 1;
            }
            if (arr[i] == arr2[i % 8]) {
                cnt2 += 1;
            }
            if (arr[i] == arr3[i % 10]) {
                cnt3 += 1;
            }
        }
        result.add(cnt1);
        result.add(cnt2);
        result.add(cnt3);
        int maxvalue = Collections.max(result);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == maxvalue) {
                submit.add(i + 1);
            }
        }
        return submit.stream().mapToInt(Integer::intValue).toArray();
    }

}
