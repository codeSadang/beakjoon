package class4.풀어야할문제.LCS_9251_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모2 {

    static String str1, str2;

    static int[][] dp, memoization;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length()+1][str2.length()+1];
        memoization = new int[str1.length()+1][str2.length()+1];

        bottomeUp();

        topDown();

    }

    private static void topDown() {
        System.out.println( lcs(str1.length(), str2.length()) );
    }

    private static int lcs(int i, int j) {
        if( i == 0 || j == 0 ) {
            return 0;
        }

        if( memoization[i][j] != 0 ) {
            return memoization[i][j];
        }

        if( str1.charAt(i-1) == str2.charAt(j-1) ) {
            return memoization[i][j] = lcs(i-1, j-1) + 1;
        } else {
            return memoization[i][j] = Math.max( lcs(i-1, j), lcs(i, j-1) );
        }
    }

    private static void bottomeUp() {
        for( int i = 1; i <= str1.length(); i++ ) {
            for( int j = 1; j <=str2.length(); j++ ) {
                if( str1.charAt(i-1) == str2.charAt(j-1) ) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        System.out.println( dp[str1.length()][str2.length()] );
    }


}
