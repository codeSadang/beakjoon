package class4.풀어야할문제.파이프옮기기1_17070_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 파이프는 3가지 방향으로 움직일 수 있다.
 * 2. 파이프는 가로, 세로, 대각선으로 움직일 수 있다.
 *
 * 가로 : 1, 세로 : 2, 대각선 : 3
 *
 * 1. 파이프가 가로인 경우
 *  - 1 가로, 3 대각선
 *
 *  2. 파이프가 세로인 경우
 *  - 2 세로, 3 대각선
 *
 *  3. 파이프가 대각선인 경우
 *  - 1 가로, 2 세로, 3 대각선
 * */
public class 홍창모2 {

    static int N;

    static int[][] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        house = new int[N+2][N+2];

        for(int i = 0; i <= N+1; i++) {
            for( int j = 0; j <= N+1; j++ ) {
                house[i][j] = 1;
            }
        }

        for( int i = 1; i <=N ; i++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 1; j <= N; j++ ) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(dfs(1,2,1));

    }

    private static int dfs(int x, int y, int status) {
        int cnt = 0;

        if( x == N && y == N ) {
            return 1;
        }

        // 파이프의 상태가 가로인 경우
        if( status == 1 ) {

            // 가로로 움직이는 경우
            if( y+1 <= N && house[x][y+1] == 0 ) {
                cnt += dfs(x,y+1,1);
            }

            // 대각선으로 움직이는 경우
            if( x+1 <= N && y+1 <= N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0 ) {
                cnt += dfs(x+1, y+1, 3);
            }

        }

        // 파이프의 상태가 세로인 경우
        if( status == 2 ) {

            // 세로로 움직이는 경우
            if( x+1 <= N && house[x+1][y] == 0 ) {
                cnt += dfs(x+1, y, 2);
            }

            // 대각선으로 움직이는 경우
            if( x+1 <= N && y+1 <= N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0 ) {
                cnt += dfs(x+1, y+1, 3);
            }

        }

        // 파이프의 상태가 대각선인 경우
        if( status == 3 ) {

            // 가로로 움직이는 경우
            if( y+1 <= N && house[x][y+1] == 0 ) {
                cnt += dfs(x,y+1,1);
            }

            // 세로로 움직이는 경우
            if( x+1 <= N && house[x+1][y] == 0 ) {
                cnt += dfs(x+1, y, 2);
            }

            // 대각선으로 움직이는 경우
            if( x+1 <= N && y+1 <= N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0 ) {
                cnt += dfs(x+1, y+1, 3);
            }

        }

        return cnt;
    }


}
