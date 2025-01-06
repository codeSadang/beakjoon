package 자료구조.풀어야할문제.제로_10773_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 홍창모 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < N; i++ ) {
            int num = Integer.parseInt(br.readLine());

            if( num == 0 ) {
                stack.pop();
            } else {
                stack.push(num);
            }

        }

        int sum = 0;

        for( int x : stack ) {
            sum += x;
        }

        System.out.println(sum);
    }
}
