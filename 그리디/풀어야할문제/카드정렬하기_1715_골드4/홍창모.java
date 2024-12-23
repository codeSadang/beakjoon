package 그리디.풀어야할문제.카드정렬하기_1715_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 홍창모 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        /* 우선순위 큐 사용법 찾아보기 */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b;
            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}