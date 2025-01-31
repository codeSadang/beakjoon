package 다이나믹프로그래밍.풀어야할문제.부녀회장이될테야_2775_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int T;

    static int [][] apt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        T = Integer.parseInt(br.readLine());

        apt = new int[15][15];

        // 0층
        for( int i = 0; i < 15; i++ ) {
            apt[0][i] = i;
        }

        // 1층 ~ 14층
        for( int i = 1; i < 15; i++ ) {
            for( int j = 1; j < 15; j++ ) {
                apt[i][j] += apt[i-1][j] + apt[i][j-1];
            }
        }

        for( int i = 0; i < T; i++ ) {

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(apt[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}
