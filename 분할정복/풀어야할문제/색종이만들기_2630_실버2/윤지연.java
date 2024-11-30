package 분할정복.풀어야할문제.색종이만들기_2630_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int[][] papers;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        papers = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePaper(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void dividePaper(int x, int y, int size) {
        if (isSame(x, y, size)) {
            if (papers[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int half = size / 2;
        dividePaper(x, y, half); // 왼쪽 위
        dividePaper(x + half, y, half); // 왼쪽 아래
        dividePaper(x, y + half, half); // 오른쪽 위
        dividePaper(x + half, y + half, half); // 오른쪽 아래
    }

    // 색깔 확인(0 or 1)
    private static boolean isSame(int x, int y, int size) {
        int color = papers[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (papers[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
