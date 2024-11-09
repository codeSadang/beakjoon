package 트리.풀어야할문제.상근이의여행_9372_실버4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N개국을 여행하면서 자아를 찾기
 * 비행기를 무서워하기 떄문에 최대한 적은 비행기를 타고 국가 이동
 * 비행 스케줄이 주어졌을 떄, 상근이가 가장 적은 종류의 비행기를 타고
 * 모든 국가들을 여행할 수 있도록 도와주자
 *
 * 한 국가에서 다른 국가로 이동할 떄 다른 국가를 거쳐가도 된다. (이미 방문해도 된다.)
 *
 *
 * 첫번째 줄에는 테스트 케이스 T
 * 첫번쨰 줄에는 국가의 수와 비행기 종류 M 이 주어진다.
 * 이후 M개의 줄에 a,b 쌍들이 입력된다.
 *
 * a,b를 왕복하는 비행기가 있다는것을 의미한다.
 * 1 <= a
 * b <= n
 * a != b
 *
 *
 */
public class 황병수 {

    static int T,N,M;
    static boolean[] visited;

    static int[] testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            List<List<Integer>> AList = new ArrayList<>();

            for (int k = 0; k <= N; k++) {
                AList.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                AList.get(u).add(v);
                AList.get(v).add(u);
            }

            bfs(1);


            int result = i + 1;


            sb.append(result).append(" ");
        }

        System.out.println(String.valueOf(sb).trim());
    }

    private static int bfs(int index) {
        Deque<Integer> queue = new Deque<>();
        visited = new boolean[N+1];
        queue.add(index);
        visited[index] = true;

        int flightCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : AList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    flightCount++;
                }
            }
        }
        return flightCount;

    }
}
