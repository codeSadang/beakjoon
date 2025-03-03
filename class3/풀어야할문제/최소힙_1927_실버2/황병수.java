package class3.풀어야할문제.최소힙_1927_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소 힙을 이용하여 프로그램을 작성하라
 * - 배열에 자연수 x를 넣는다.
 * - 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 * - 자연수라면 추가
 * - 0이라면 배열에서 가장 작은 값을 출력하고 해당 값을 제거
 */
public class 황병수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 최소 힙 (PriorityQueue 활용)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (!minHeap.isEmpty()) sb.append(minHeap.poll()).append('\n');
                else sb.append(0).append('\n');
            } else {
                minHeap.add(x);
            }
        }

        System.out.println(sb);
    }
}
