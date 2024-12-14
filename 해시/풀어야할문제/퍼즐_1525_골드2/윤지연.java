package 해시.풀어야할문제.퍼즐_1525_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 윤지연 {
    /*최소한의 이동으로 목표상태를 만들자
    * 상하좌우 이동하여 0과 숫자 자리 바꿈
    * 이동방향
    * 입력처리
    * 3*3 퍼즐 문자열 처리 "103425786" (예제입력1번 기준)
    * 탐색
    * 시작 상태를 큐에 넣고, 방문 집합에 기록
    * 큐에서 상태를 꺼내 0 위치를 찾는다.
    * 0을 상하좌우로 이동시켜 새로운 상태를 만든다.
    * 새로운 상태가 목표 상태이면 이동 횟수를 출력한다.
    * 새로운 상태가 방문하지 않은 상태라면 큐에 추가한다.
    * 종료조건
    * 큐가 비었는데도 목표 상태를 찾지 못하면 -1을 출력한다.
    *
    * 주의사항
    * 경계처리: 0이 퍼즐 경계를 벗어나지 않도록 방향을 제한해야 한다.
    * 시간 복잡도: 가능한 모든 상태를 탐색하므로 9!(362,880) 상태를 탐색할 수 있다.
    * */

    static String start;
    static String goal = "123456780";
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
        }
        start = sb.toString();

        bfs(start);
        System.out.println(result);
    }

    static void bfs(String start) {
        Deque<String> queue = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.offer(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            // 목표 상태 도달 시 종료
            if (cur.equals(goal)) {
                result = visited.get(cur);
                return;
            }

            int zeroIndex = cur.indexOf('0');
            int x = zeroIndex / 3;
            int y = zeroIndex % 3;

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 경계체크
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    int newIndex = nx * 3 + ny;

                    // 0과 다른 숫자 스왑
                    char[] nextState = cur.toCharArray();
                    char temp = nextState[zeroIndex];
                    nextState[zeroIndex] = nextState[newIndex];
                    nextState[newIndex] = temp;

                    String newState = new String(nextState);

                    // 처음 방문 시 큐에 추가
                    if (!visited.containsKey(newState)) {
                        queue.offer(newState);
                        visited.put(newState, visited.get(cur) + 1);
                    }
                }

            }
        }
        // 목표 상태 미 도달 시 -1
        result = -1;
    }
}
