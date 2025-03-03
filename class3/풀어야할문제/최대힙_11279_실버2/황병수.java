package class3.풀어야할문제.최대힙_11279_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 최대 힙 (PriorityQueue 활용)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((a,b) -> b-a));

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (!maxHeap.isEmpty()) sb.append(maxHeap.poll()).append('\n');
                else sb.append(0).append('\n');
            } else {
                maxHeap.add(x);
            }
        }

        System.out.println(sb);
    }
}
