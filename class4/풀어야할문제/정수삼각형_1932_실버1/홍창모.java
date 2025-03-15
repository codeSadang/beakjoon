package class4.풀어야할문제.정수삼각형_1932_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N;
    static int[][] triangle;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());

            for( int j = 0; j <= i; j++ ) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 삼각형의 역순으로 비교하면서 올라간다.
        for( int i = N-2; i >= 0; i-- ) {
            for( int j = 0; j <= i; j++ ) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        System.out.println(triangle[0][0]);

    }
}
