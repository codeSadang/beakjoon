package 분할정복.풀어야할문제.색종이만들기_2630_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 여러개의 정사각형 칸들로 이루어진 정사각형 모양에 종이가 주어져 있다.
 * 각 정사가형은 하얀색이나, 파랑색
 * 일정학 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 종이를 만들려고 한다.
 * 주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 종이를 만들려고 한다.
 *
 * [규칙]
 * 전체가 다 같은색이 아니라면 가로와 세로중간을 잘라서 N/2, N/2로 나눈다.
 * 모두 한 색이 아니라면 또 나눈다.
 */
public class 황병수 {
    static int N;

    static int[][] ListA;
    static int[] result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ListA = new int[N][N];
        result = new int[2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                    ListA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divideAndConquer(0,0, N);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    static void divideAndConquer(int x, int y, int size) {


            if (checkSameColor(x, y, size)) {
                result[ListA[x][y]]++; // 해당 색상 카운트 증가 (0: 하얀색, 1: 파란색)
                return;
            }

            // 색상이 다르면 4등분으로 나눔
            int newSize = size / 2; // 영역의 크기를 절반으로 줄임
            divideAndConquer(x, y, newSize); // 좌상
            divideAndConquer(x, y + newSize, newSize); // 우상
            divideAndConquer(x + newSize, y, newSize); // 좌하
            divideAndConquer(x + newSize, y + newSize, newSize); // 우하
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
