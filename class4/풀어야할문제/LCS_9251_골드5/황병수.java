package class4.풀어야할문제.LCS_9251_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 황병수 {

    static int[][] dp;
    static int[][] memo;
    static int len1, len2;
    static String str1, str2;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();
        len1 = str1.length();
        len2 = str2.length();

        dp = new int[len1 + 1][len2 + 1];
        memo = new int[len1 + 1][len2 + 1];


        // 아래 두 방식을 선택할 때에는 N,M 이 1000 둘 다 OK
        // 만약 N,M 이 1000 이상이라면 BOTTOM UP 방식을 사용할 것 그렇지 않으면 stackoverflow 발생 가능성 있음
        // DP 방식 풀이 (BOTTOM UP)
        DP();

        // MEMOIZATION 방식 풀이 (TOP DOWN & MEMOIZATION)
        MEMO();
    }


    private static void DP() {
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[len1][len2]);
    }


    private static void MEMO() {
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(LCS(len1, len2));
    }

    static int LCS(int i, int j) {
        if (i == 0 || j == 0) return 0; // 베이스 케이스
        if (memo[i][j] != -1) return memo[i][j]; // 이미 계산된 값이면 반환

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            memo[i][j] = LCS(i - 1, j - 1) + 1;
        } else {
            memo[i][j] = Math.max(LCS(i - 1, j), LCS(i, j - 1));
        }

        return memo[i][j];
    }

}
