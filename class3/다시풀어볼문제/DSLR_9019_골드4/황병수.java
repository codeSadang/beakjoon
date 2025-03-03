package class3.다시풀어볼문제.DSLR_9019_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * D : n을 두배로 바꾼다 / 결과가 9999보다 크면 10000으로 나눈 나머지를 취한다.
 * S : n-1 결과를 저장 / n이 0이라면, 9999
 * L : n의 각 자릿수를 왼편으로 회전
 * R : n의 각 자릿수를 오른쪽으로 회전
 */
public class 황병수 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            bfs(before, after);
        }

        System.out.println(sb);
    }

    private static void bfs(int start, int target) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];

        queue.add(new Pair(start, "")); // 숫자, 변환 과정
        visited[start] = true;

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int num = poll.num;
            String path = poll.path;

            if (num == target) {
                sb.append(path).append('\n');
                return;
            }

            int D = (num * 2) % 10000;
            int S = (num == 0) ? 9999 : num - 1;
            int L = (num % 1000) * 10 + num / 1000;
            int R = (num % 10) * 1000 + num / 10;

            if (!visited[D]) {
                queue.add(new Pair(D, path + "D"));
                visited[D] = true;
            }
            if (!visited[S]) {
                queue.add(new Pair(S, path + "S"));
                visited[S] = true;
            }
            if (!visited[L]) {
                queue.add(new Pair(L, path + "L"));
                visited[L] = true;
            }
            if (!visited[R]) {
                queue.add(new Pair(R, path + "R"));
                visited[R] = true;
            }
        }
    }

    static class Pair {
        int num;
        String path;

        public Pair(int num, String path) {
            this.num = num;
            this.path = path;
        }
    }
}