package 분할정복.풀어야할문제.별찍기_2447_골드5;

import java.io.*;

public class 윤지연 {
    static int N;
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stars = new char[N][N];

        drawStar(0, 0, N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(stars[i][j] == '*' ? '*' : ' ');
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void drawStar(int x, int y, int size) {
        if (size == 1) {
            stars[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                drawStar(x + i * newSize, y + j * newSize, newSize);
            }
        }

    }
}
