package sort;

import java.util.*;

public class insertionSort {
    public int[] insertionsort(int[] arr) {
        int n = arr.length;
        int i, j;

        // 인덱스 0은 이미 정렬된 것으로 볼 수 있다.
        for (i = 1; i < n; i++) {
            int key = arr[i]; // 현재 삽입될 숫자인 i번째 정수를 key 변수로 복사

            // 현재 정렬된 배열은 i-1까지이므로 i-1째부터 역순으로 조사한다.
            // j 값은 음수가 아니어야 되고
            // key 값보다 정렬된 배열에 있는 값이 크면 j번째를 j+1번째로 이동
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        System.out.println("Insertionsort");
        return arr;
    }
}
