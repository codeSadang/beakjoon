package 백트래킹.풀어야할문제.배열돌리기_17406_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 4

 * N * M 크기인 배열 A가 잇을 떄,
 * 배열 A의 값은 각 행에 있는 모든 수의 합 중 최소값을 의미
 * 행 별로 합을 구한 뒤 그 중 최소값을 찾으면 됨

 * 회전 연산은 (r, c, s) 로 이루어져 있다.
 * 가장 왼쪽 윗 칸이 (r-s, c-s)
 * 가장 오른쪽 아랫 칸이 (r+s, c+s) 정사각형을 시게방향으로 한칸씩 돌린다는 의미!!
 *
 *
 * 값을 다 할당한 후
 *
 * 1. k번 만큼 돌릴거야
 * 2. K번 돌았으면! 종료
 *
 * 3.
 */
public class 황병수 {

    static int[][] A;
    static int N,M,K;
    static int[][] circleList;
    static boolean[] visited;
    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        circleList = new int[K][3];
        visited = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            circleList[i][0] = Integer.parseInt(st.nextToken()) -1;
            circleList[i][1] = Integer.parseInt(st.nextToken()) -1;
            circleList[i][2] = Integer.parseInt(st.nextToken());
        }

        backtracking(0,  A);

        System.out.println(minResult);
    }

    private static void backtracking(int count, int[][] nowMap) {
        if (count == K) {
            // 배열 A의 각 행의 합 중 최소값 계산
            int minSum = getMinRowSum(nowMap);
            minResult = Math.min(minResult, minSum);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // 배열 회전 후 다음 단계 진행
                int[][] rotatedMap = moveAndCalc(circleList[i], nowMap);
                backtracking(count + 1, rotatedMap);
                visited[i] = false;
            }
        }
    }

    private static int[][] moveAndCalc(int[] circle, int[][] nowMap) {

        int[][] tempMap = nowMap.clone();
        for (int i = 0; i < N; i++) {
            tempMap[i] = nowMap[i].clone();
        }

        int r = circle[0];
        int c = circle[1];
        int s = circle[2];

        int minX = c-s;
        int minY = r-s;

        int maxY = r+s;
        int maxX = c+s;

        int sizeX = maxX-minX;
        int sizeY = maxY-minY;

        int size = Math.min(sizeX, sizeY);

        for (int j = 0; j < size/2; j++) {
            int startX = minX + j;
            int startY = minY + j;
            int endX = maxX - j;
            int endY = maxY - j;

            if (endY == startY || endX == startX) break;

            // 오른쪽으로 이동부터
            for (int i = 0; i < endX - startX; i++) {
                tempMap[startY][startX + i + 1] = nowMap[startY][startX + i]; // 우로
            }
            // 아래쪽으로 이동
            for (int i = 0; i < endY - startY; i++) {
                tempMap[startY + i + 1][endX] = nowMap[startY + i][endX]; // 아래로
            }
            // 왼쪽으로 이동
            for (int i = 0; i < endX - startX; i++) {
                tempMap[endY][endX - i - 1] = nowMap[endY][endX - i]; // 좌로
            }
            // 위쪽으로 이동
            for (int i = 0; i < endY - startY; i++) {
                tempMap[endY - i - 1][startX] = nowMap[endY - i][startX]; // 위로
            }
        }
        return tempMap;
    }

    private static int getMinRowSum(int[][] map) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                rowSum += map[i][j];
            }
            minSum = Math.min(minSum, rowSum);
        }
        return minSum;
    }
}
