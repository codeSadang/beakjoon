package 데이크스트라.풀어야할문제.숨바꼭질3_13549_골드5;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홍창모 {
    static int a,b;

    static List<int[]> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 위치
        a = Integer.parseInt(st.nextToken());
        // 동생의 위치
        b = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= 100000; i++) {
            graph.add(new int[]{i,0});
        }

        System.out.println(dijkstra(a,b));
    }

    private static int dijkstra(int a, int b) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{a,0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if(current[0] == b) {
                return current[1];
            }

            if(current[0] * 2 <= 100000 && graph.get(current[0] * 2)[1] == 0) {
                graph.get(current[0] * 2)[1] = current[1];
                pq.add(new int[]{current[0] * 2, current[1]});
            }

            if(current[0] + 1 <= 100000 && graph.get(current[0] + 1)[1] == 0) {
                graph.get(current[0] + 1)[1] = current[1] + 1;
                pq.add(new int[]{current[0] + 1, current[1] + 1});
            }

            if(current[0] - 1 >= 0 && graph.get(current[0] - 1)[1] == 0) {
                graph.get(current[0] - 1)[1] = current[1] + 1;
                pq.add(new int[]{current[0] - 1, current[1] + 1});
            }
        }
        return -1;
    }
}
