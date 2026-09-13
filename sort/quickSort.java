package sort;

public class quickSort {
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗을 기준으로 배열은 분할하고, 최종 배치된 피벗의 인덱스를 받음
            int pivotIndex = partition(arr, low, high);

            // 피벗을 제외한 왼쪽 부분 배열 정렬
            quicksort(arr, low, pivotIndex - 1);

            // 피벗을 제외한 오른쪽 부분 배열 정렬
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 가장 오른쪽 원소를 피벗으로 선택
        int pivot = arr[high];
        int i = low - 1; // 피벗보다 작은 값들이 위치할 구역의 끝 인덱스

        for (int j = low; j < high; j++) {
            // 현재 원소가 피벗보다 작거나 같으면 i를 증가시키고 교환
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // 피벗을 자신의 최종 올바른 위치(i+1)로 이동
        swap(arr, i + 1, high);
        return i + 1; // 피벗의 최종 위치 반환
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
