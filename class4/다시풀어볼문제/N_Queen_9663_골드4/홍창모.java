package class4.다시풀어볼문제.N_Queen_9663_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int N;

    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        System.out.println( backtracking(0) );
    }

    private static int backtracking(int num) {
        if( num == N ) {
            return 1;
        }

        int result = 0;
        for( int i = 0; i < N; i++ ) {
            if( isPossible(num, i) ) {
                board[num][i] = 1;
                visited[num][i] = true;
                result += backtracking(num+1);
                board[num][i] = 0;
                visited[num][i] = false;
            }
        }

        return result;
    }

    private static boolean isPossible(int x, int y) {
        for( int i = 0; i < N; i++ ) {
            if( visited[i][y] ) return false;
        }

        for( int i = 0; i < N; i++ ) {
            if( visited[x][i] ) return false;
        }

        for( int i = 1; i < N; i++ ) {
            if( x-i >= 0 && y-i >= 0 && visited[x-i][y-i] ) return false;
            if( x-i >= 0 && y+i < N && visited[x-i][y+i] ) return false;
            if( x+i < N && y-i >= 0 && visited[x+i][y-i] ) return false;
            if( x+i < N && y+i < N && visited[x+i][y+i] ) return false;
        }

        return true;
    }
}
