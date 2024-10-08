package 너비우선탐색.풀어야할문제.숨바꼭질_1697_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 황병수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = bfs(N, K);
        System.out.println(result);
    }

    static int bfs(int position, int target) {

        boolean[] visited = new boolean[100001]; // 문제 조건에 따라 범위 설정
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {position, 0});
        visited[position] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nPosition = now[0];
            int distance = now[1];

            if (nPosition == target) {
                return distance;
            }

            // 각각의 연산을 수행한 위치를 따로 계산하여 큐에 추가
            int[] nextPositions = {nPosition + 1, nPosition - 1, nPosition * 2};

            for (int nextPosition : nextPositions) {
                // 범위 검사와 방문 여부 검사
                if (nextPosition >= 0 && nextPosition <= 100000 && !visited[nextPosition]) {
                    queue.add(new int[]{nextPosition, distance + 1});
                    visited[nextPosition] = true;  // 방문 표시
                }
            }
        }

        return -1;
    }
}