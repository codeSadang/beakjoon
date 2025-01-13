package 다이나믹프로그래밍.풀어야할문제.부녀회장이될테야_2775_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {

    static int k, n;
    static StringBuilder answer = new StringBuilder();
    static int[][] dpA;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            dp(k, n);
        }
        System.out.println(answer.toString());
    }

    static void dp(int k, int n) {
        dpA = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dpA[0][i] = i;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dpA[i][j] = dpA[i - 1][j] + dpA[i][j - 1];
            }
        }
        answer.append(dpA[k][n]).append("\n");
    }
}
