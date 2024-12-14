package 분할정복.풀어야할문제.치킨TOPN_11582_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, K;

    static int[] CHIKEIN_HOUSE;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 치킨집의 수
        N = Integer.parseInt(br.readLine());

        // 치킨집 맛의 수치
        CHIKEIN_HOUSE = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            CHIKEIN_HOUSE[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        // 그룹의 크기
        int groupSize = N / K;

        for( int i = 0; i < N; i += groupSize ) {
            mergeSort(i, i + groupSize);
        }

        System.out.print(sb.toString());

    }

    public static void mergeSort(int start, int end) {
        int[] tmp = new int[end - start];
        for (int i = start; i < end; i++) {
            tmp[i - start] = CHIKEIN_HOUSE[i];
        }
        Arrays.sort(tmp);
        for (int i = 0; i < end - start; i++) {
            sb.append(tmp[i]).append(" ");
        }
    }
}
