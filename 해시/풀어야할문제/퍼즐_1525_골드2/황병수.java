package 해시.풀어야할문제.퍼즐_1525_골드2;

import java.io.*;
import java.util.*;
public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder start = new StringBuilder();

        // 퍼즐 초기 상태 입력받기
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                start.append(st.nextToken());
            }
        }

        System.out.println(bfs(start.toString()));
    }

    // BFS 함수
    public static int bfs(String start) {
        String target = "123456780"; // 목표 상태
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
        int[] dy = {0, 0, -1, 1};

        // 방문 상태를 저장할 HashMap
        HashMap<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.put(start, 0); // 초기 상태와 이동 횟수 기록

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int moves = visited.get(current);

            // 목표 상태 도달
            if (current.equals(target)) {
                return moves;
            }

            // 빈 칸(0)의 위치 찾기
            int zeroIndex = current.indexOf('0');
            int x = zeroIndex / 3;
            int y = zeroIndex % 3;

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    // 새로운 상태 계산
                    int newIndex = nx * 3 + ny;
                    String nextState = swap(current, zeroIndex, newIndex);

                    // 방문하지 않은 상태면 큐에 추가
                    if (!visited.containsKey(nextState)) {
                        visited.put(nextState, moves + 1);
                        queue.add(nextState);
                    }
                }
            }
        }

        return -1; // 목표 상태에 도달할 수 없는 경우
    }

    // 문자열에서 두 위치의 값을 교환
    public static String swap(String state, int i, int j) {
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
