package 분할정복.풀어야할문제.치킨TOPN_11582_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균rabbit {

    public static int N;
    public static int[] CHICKEN_LIST;
    public static int K;

    /****
     * Reads input values, divides the array into K equal segments, applies merge sort to each segment independently, and prints the resulting partially sorted array.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if an I/O error occurs during input reading
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        CHICKEN_LIST = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            CHICKEN_LIST[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        int groupSize = N / K;
        for (int i = 0; i < N; i += groupSize) {
            mergeSort(i, Math.min(i + groupSize - 1, N - 1));
        }

        for (int num : CHICKEN_LIST) {
            System.out.print(num + " ");
        }
    }

    /**
     * Recursively sorts a subarray of CHICKEN_LIST between the specified start and end indices using merge sort.
     *
     * @param start the inclusive starting index of the subarray to sort
     * @param end the inclusive ending index of the subarray to sort
     */
    private static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        // 재귀로 왼쪽과 오른쪽 정렬
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        merge(start, mid, end);
    }

    /**
     * Merges two consecutive sorted subarrays of CHICKEN_LIST into a single sorted segment.
     *
     * The first subarray spans from {@code start} to {@code mid}, and the second from {@code mid + 1} to {@code end}.
     * After merging, the elements from {@code start} to {@code end} in CHICKEN_LIST are sorted in non-decreasing order.
     *
     * @param start the starting index of the first subarray
     * @param mid the ending index of the first subarray
     * @param end the ending index of the second subarray
     */
    private static void merge(int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        // 두 부분 배열을 병합
        while (i <= mid && j <= end) {
            if (CHICKEN_LIST[i] <= CHICKEN_LIST[j]) {
                temp[k++] = CHICKEN_LIST[i++];
            } else {
                temp[k++] = CHICKEN_LIST[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = CHICKEN_LIST[i++];
        }
        while (j <= end) {
            temp[k++] = CHICKEN_LIST[j++];
        }

        for (i = 0; i < temp.length; i++) {
            CHICKEN_LIST[start + i] = temp[i];
        }
    }

}