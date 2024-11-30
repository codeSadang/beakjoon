package 분할정복.풀어야할문제.쿼드트리_1992_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    static int N;
    static int[][] videos;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        videos = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                videos[i][j] = Integer.parseInt(tokens[j]);
            }
        }


        divideVideo(0, 0, N);

        System.out.println(answer.toString());
    }

    private static void divideVideo(int x, int y, int size) {
        int half = size / 2;
        /*현재 영역이 모두 같으면 숫자 추가
         * 다르면 '(' 추가하고 재귀 호출
         * 4등분 탐색 끝나면 ')' 추가
         * */
        if (isSame(x, y, size)) {
            answer.append(videos[x][y]);
            return;
        }

        answer.append("(");
        divideVideo(x, y, half); // 왼쪽 위
        divideVideo(x, y + half, half); // 오른쪽 위
        divideVideo(x + half, y, half); // 왼쪽 아래
        divideVideo(x + half, y + half, half); // 오른쪽 아래
        answer.append(")");
    }

    private static boolean isSame(int x, int y, int size) {
        int element = videos[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (videos[i][j] != element) {
                    return false;
                }
            }
        }
        return true;
    }
}