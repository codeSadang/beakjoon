package class3.풀어야할문제.뱀과사다리게임_16928_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 100개의 칸으로 나누어진 보드판에서 게임 진행
 * 판에는 1부터 100까지 적혀있음
 * 주사위를 굴려 나온 수 만큼 이동하고, 플레이어가 i, 주사위가 4 라면 i+4 칸으로이동
 * 100칸을 넘어서면 이동할 수 없다.
 * 도착한 칸이 사다리라면 사다리를 타고 위로 올라간다.
 * 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려간다.
 * 100번칸에 도달하기 위해 굴려야 하는 횟수의 최소 값을 구하여라
 */
public class 황병수 {

    static int[] map = new int[101]; // 이동 횟수 저장
    static boolean[] visited = new boolean[101]; // 방문 체크
    static HashMap<Integer, Integer> ladder = new HashMap<>();
    static HashMap<Integer, Integer> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 사다리 경로
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder.put(start, end);
        }

        // 뱀 경로
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake.put(start, end);
        }

        // BFS 탐색 실행
        int result = bfs();
        System.out.println(result);

    }

    private static int bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0}); // 시작 위치 (1번 칸), 이동 횟수 0
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int moves = current[1];

            // 도착 지점에 도달하면 정답 반환
            if (position == 100) {
                return moves;
            }

            // 주사위 굴리기 (1~6)
            for (int dice = 1; dice <= 6; dice++) {
                int nextPosition = position + dice;

                // 100을 넘어가면 무시
                if (nextPosition > 100) {
                    continue;
                }

                // 사다리나 뱀 확인
                if (ladder.containsKey(nextPosition)) {
                    nextPosition = ladder.get(nextPosition);
                } else if (snake.containsKey(nextPosition)) {
                    nextPosition = snake.get(nextPosition);
                }

                // 방문하지 않은 위치만 큐에 추가
                if (!visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.add(new int[]{nextPosition, moves + 1});
                }
            }
        }
        return -1; // 도달할 수 없는 경우 (이론적으로는 발생하지 않음)
    }
}
