package class4.풀어야할문제.가장긴부분수열_11053_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {
    static int[] dp, map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1); // 최소 길이는 1

        int maxLength = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (map[j] < map[i]) { // 앞에 있는 숫자가 현재 숫자보다 작다면
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);

    }
}
