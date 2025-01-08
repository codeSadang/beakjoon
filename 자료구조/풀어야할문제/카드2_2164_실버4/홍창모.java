package 자료구조.풀어야할문제.카드2_2164_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 홍창모 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for( int i = 1; i <=N; i++ ) {
            q.add(i);
        }

        while(q.size() > 1) {
            // 선입 선출
            q.poll();

            int lastNum = q.pollFirst();

            q.offerLast(lastNum);
        }

        System.out.print(q.poll());

    }
}
