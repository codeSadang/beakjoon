package 분할정복.풀어야할문제.쿼드트리_1992_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  흑백 영상을 압축하여 표현하는 데이터 구조 쿼드트리
 *  흰점 - 0
 *  검은점 - 1
 *
 */
public class 황병수 {
    static int N;
    static int[][] ListA;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ListA = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                ListA[i][j] = Integer.parseInt(split[j]);
            }
        }
        backtracking(0,0, N);
        System.out.println(sb);
    }

    static void backtracking(int x, int y, int size) {

        if (checkSameColor(x, y, size)) {
            sb.append(ListA[x][y]); // 영역이 모두 같은 색이면 해당 숫자 추가
            return;
        }

        sb.append("("); // 분할 시작 표시

        // 색상이 다르면 4등분으로 나눔
        int newSize = size / 2; // 영역의 크기를 절반으로 줄임
        backtracking(x, y, newSize); // 좌상
        backtracking(x, y + newSize, newSize); // 우상
        backtracking(x + newSize, y, newSize); // 좌하
        backtracking(x + newSize, y + newSize, newSize); // 우하

        sb.append(")"); // 분할 시작 표시
    }

    // 현재 영역이 모두 같은 색인지 확인
    static boolean checkSameColor(int x, int y, int size) {
        int color = ListA[x][y]; // 시작점의 색상
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (ListA[i][j] != color) {
                    return false; // 다른 색이 하나라도 있으면 false
                }
            }
        }

        return true; // 모두 같은 색이면 true
    }

}
