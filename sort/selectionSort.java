package sort;

import java.util.*;

public class selectionSort {
    public int[] selectionsort(int[] arr) {
        int n = arr.length;

        // 1. 전체 배열의 앞자리부터 차례로 채워나감 (0번 인덱스부터 n-2번 인덱스까지)
        for (int i = 0; i < n - 1; i++) {
            // 이번 회차의 시작 지점 i를 최솟값의 인덱스로 가정
            int minIndex = i;

            // 2. [최솟값 탐색 구간] i+1부터 끝까지 순회하며 더 작은 원소의 인덱스를 찾음
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}