package 구현.풀어야할문제.왕복_18311_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int N;
    static long K;
    static long[] distances;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        distances = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        long totalDistance = 0;
        // 정방향 이동
        for (int i = 0; i < N; i++) {
            totalDistance += distances[i];
            if (totalDistance > K) {
                System.out.println(i + 1);
                return;
            }
        }

        // 역방향 이동
        for (int i = N-1; i >= 0; i--) {
            totalDistance += distances[i];
            if (totalDistance > K) {
                System.out.println(i + 1);
                return;
            }
        }

    }

}
