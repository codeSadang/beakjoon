package 분할정복.풀어야할문제.치킨TOPN_11582_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N, k;
    static int[] scores, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        scores = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        int size = N / k; // 정렬 구간 크기
        for (int i = 0; i < N; i += size) {
            mergeSort(i, i + size - 1);
        }
        
        for (int i = 0; i < N; i++) {
            answer.append(scores[i]).append(" ");
        }

        System.out.println(answer);
    }

    static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (scores[i] <= scores[j]) {
                temp[k++] = scores[i++];
            } else {
                temp[k++] = scores[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = scores[i++];
        }

        while (j <= right) {
            temp[k++] = scores[j++];
        }

        for (int l = left; l <= right; l++) {
            scores[l] = temp[l];
        }
    }
}
