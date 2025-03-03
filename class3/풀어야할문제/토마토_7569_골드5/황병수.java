package class3.풀어야할문제.토마토_7569_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 토마토들의 인접한 곳에 이는 익지 않은 토마토는 익은 토마토의 영향을 받게된다.
 * 위 아래 왼쪽 오른쪽 앞 뒤 에 영향을 준다. / 대각선은 영향 없음
 * 몇일이 지나면 모든 토마토가 익게되는데 최소 일수를 구하고 싶음
 */
public class 황병수 {

    static int[][][] tomatoList;
    static List<int[]> rapedTomato;
    static int lastDay,M,N,H;
    static int totalZero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        lastDay = 0;

        tomatoList = new int[H][N][M];
        rapedTomato = new ArrayList<>();

        // 상자의 개수
        for (int i = 0; i < H; i++) {
            // 각 상자 할당
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoList[i][j][k] = Integer.parseInt(st.nextToken());

                    if (tomatoList[i][j][k] == 1) {
                        rapedTomato.add(new int[]{i,j,k});
                    }

                    if (tomatoList[i][j][k] == 0) {
                        totalZero++;
                    }

                }
            }
        }

        // 너비 우선 탐색
        calcDay();

        // 결과 출력

        System.out.println(totalZero == 0 ? lastDay : -1);
    }

    private static void calcDay() {
        // 우선순위 큐 (day 기준 오름차순 정렬)
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[3], b[3]));

        int[] dx = {0, 0, -1, 1, 0, 0}; // x축 (좌우)
        int[] dy = {-1, 1, 0, 0, 0, 0}; // y축 (상하)
        int[] dz = {0, 0, 0, 0, -1, 1}; // z축 (위아래)

        for (int[] tomato : rapedTomato) {
            int nowH = tomato[0];
            int nowN = tomato[1];
            int nowM = tomato[2];
            int day = 0;

            queue.add(new int[]{nowH, nowN, nowM, day});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollH = poll[0];
            int pollN = poll[1];
            int pollM = poll[2];
            int pollD = poll[3];


            for (int i = 0; i < 6; i++) {
                int nextN = pollN + dy[i];
                int nextM = pollM + dx[i];
                int nextH = pollH + dz[i];

                // 경계 조건
                if (nextN >= 0 && nextM >= 0 && nextH >= 0) {
                    if (nextN < N && nextM < M && nextH < H) {

                        // 주변 토마토 익게하기
                        if (tomatoList[nextH][nextN][nextM] == 0) {
                            tomatoList[nextH][nextN][nextM] = 1;
                            queue.add(new int[]{nextH, nextN, nextM, pollD + 1});
                            totalZero--;
                            lastDay = Math.max(lastDay, pollD + 1);
                        }
                    }
                }
            }
        }
    }
}
