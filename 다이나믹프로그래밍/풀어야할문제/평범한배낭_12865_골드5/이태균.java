package 다이나믹프로그래밍.풀어야할문제.평범한배낭_12865_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int K;

    public static int[] W;
    public static int[] V;
    public static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 물건 개수
        K = Integer.parseInt(st.nextToken()); // 최대 무게

        W = new int[K + 1];
        V = new int[K + 1];
        DP = new int[K + 1];

        // 물건 정보
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int w = K; w >= W[i]; w--) {
                DP[w] = Math.max(DP[w], DP[w - W[i]] + V[i]);
            }
        }

        System.out.println(DP[K]);
    }

}