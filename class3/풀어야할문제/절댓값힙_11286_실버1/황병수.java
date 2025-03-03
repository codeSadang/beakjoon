package class3.풀어야할문제.절댓값힙_11286_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 *  배열에 정수 x를 넣는다
 *  배열에서 절댓값이 가장 작은 값을 출력하고
 *  그 값을 배열에서 제거한다.
 *  절댓값이 가장 작은 값이 여러개일 때는 가장 자근 수를 출력하고,
 *  그 값을 배열에서 제거한다.
 */
public class 황병수 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 최소 힙 (PriorityQueue 활용)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // 원래 값 기준 오름차순
            return Integer.compare(a[1], b[1]); // 절댓값 기준 오름차순
        });

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (minHeap.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(minHeap.poll()[0]).append("\n"); // 가장 작은 값 출력 후 제거
                }
            } else {
                minHeap.add(new int[]{x, Math.abs(x)});
            }
        }

        System.out.print(sb); // 출력 최적화
    }
}
