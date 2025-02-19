package class4.풀어야할문제.파이프옮기기1_17070_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프의 위치
// 1. 가로
// 2. 세로
// 3. 대각선

// 파이프의 방향
// 1. 가로
// 2. 세로
// 3. 대각선

// 파이프의 방향이 가로인 경우
// 1. 가로
// 3. 대각선

// 파이프의 방향이 세로인 경우
// 2. 세로
// 3. 대각선

// 파이프의 방향이 대각선인 경우
// 1. 가로
// 2. 세로
// 3. 대각선

public class 홍창모 {

    static StringTokenizer st;
    static int N;

    static int[][] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        house = new int[N+2][N+2];

        for( int i = 0; i <= N+1; i++ ) {
            for( int j = 0; j <= N+1; j++) {
                house[i][j] = 1;
            }
        }

        for( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());

            for( int j = 1; j <= N; j++ ) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(1, 2, 1));

    }


    private static int dfs(int x, int y, int status) {
        if( x == N && y == N ) {
            return 1;
        }

        int cnt = 0;

        // 가로
        if( status == 1 ) {
            if( y+1 <= N && house[x][y+1] == 0 ) {
                cnt += dfs(x, y+1, 1);
            }

            if( x+1 <= N && y+1 <= N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0 ) {
                cnt += dfs(x+1, y+1, 3);
            }
        }

        // 세로
        else if( status == 2 ) {
            if( x+1 <= N && house[x+1][y] == 0 ) {
                cnt += dfs(x+1, y, 2);
            }

            if( x+1 <= N && y+1 <= N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0 ) {
                cnt += dfs(x+1, y+1, 3);
            }
        }

        // 대각선
        else if( status == 3 ) {
            if( y+1 <= N && house[x][y+1] == 0 ) {
                cnt += dfs(x, y+1, 1);
            }

            if( x+1 <= N && house[x+1][y] == 0 ) {
                cnt += dfs(x+1, y, 2);
            }

            if( x+1 <= N && y+1 <= N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0 ) {
                cnt += dfs(x+1, y+1, 3);
            }
        }

        return cnt;
    }
}
