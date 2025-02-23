package class4.풀어야할문제.LCS_9251_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    /* idea
    * 문자열 정렬x, 원래 문자열 순서를 유지하면서 공통 문자열을 찾는 것 => 부분수열
    * 같은 문자열을 발견했을 때 선택 여부(모두 확인)
    *   - 현재 위치의 문자가 같을 때 선택
    *   - 선택하지 않고 다음으로 넘어가는 경우
    * */

    /* 알고리즘
    * 같은 문자열 발견할 때마다 계산하는 재귀를 생각했으나
    * 시간 복잡도를 고려하여 DP로 변경
    * 결과값을 저장해두고 재사용*/

    /* 점화식
    * 1. 같은 문자, 이전 최장값 + 1
    * 2. 다른 문자, max(이전 최장값(str1), 이전 최장값(str2))*/

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        dp = new int[len1+1][len2+1]; // 음수값 이탈 방지를 위해 0으로 시작

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1; // 같으면 이전 최장값 + 1
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // 다르면 더 긴 최장값으로
                }
            }
        }
        System.out.println(dp[len1][len2]);
    }
}
