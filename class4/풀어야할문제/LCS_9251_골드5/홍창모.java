package class4.풀어야할문제.LCS_9251_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* TOP DOWN 방식 MEMOIZATION 방식으로 풀어보기 */
public class 홍창모 {

    static String str1, str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for( int i = 1; i <= str1.length(); i++ ) {
            for( int j = 1; j <= str2.length(); j++ ) {
                if( str1.charAt(i-1) == str2.charAt(j-1) ) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
