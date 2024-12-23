package 그리디.풀어야할문제.카드정렬하기_1715_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 황병수 {
    static int N;
    static int[] ListA;
    static int[] ListB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐

        // 카드 묶음 크기 입력
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        // 두 개의 가장 작은 묶음을 합치고 큐에 추가
        while (pq.size() > 1) {
            int first = pq.poll(); // 가장 작은 카드 묶음
            int second = pq.poll(); // 두 번째로 작은 카드 묶음

            int sum = first + second; // 두 묶음을 합친 비교 횟수
            result += sum; // 결과에 더함

            pq.add(sum); // 합친 묶음을 다시 큐에 추가
        }

        System.out.println(result);
    }
}
