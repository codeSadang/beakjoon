package 백트래킹.완료된문제.넴모넴모_14712_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int count, n, m;

    static int[][] squares;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        squares = new int[n][m];
        DFS(0, 0);
        System.out.print(count);
    }

    public static void DFS(int x, int y) {

        if (x == n) {
            // 배치된 넴모들이 2 x 2 를 이루는지 확인
            for (int i = 0; i <= n - 2; i++) {
                for (int j = 0; j <= m - 2; j++) {
                    // 2 x 2 를 이루는 경우
                    if (squares[i][j] == 1 && squares[i][j+1] == 1 &&
                            squares[i+1][j] == 1 && squares[i+1][j+1] == 1)
                        return;
                }
            }

            count++;
            return;
        }

        int ny = (y + 1 == m) ? 0 : y + 1;
        int nx = (ny == 0) ? x + 1 : x;

        // 넴모 배치
        squares[x][y] = 1;			// 넴모 배치 O
        DFS(nx, ny);

        squares[x][y] = 0;			// 넴모 배치 X
        DFS(nx, ny);
    }

}
