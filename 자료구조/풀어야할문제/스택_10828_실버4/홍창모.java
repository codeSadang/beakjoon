package 자료구조.풀어야할문제.스택_10828_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> stack = new ArrayList<>();

        for( int i = 0; i < n; i++ ) {
            st = new StringTokenizer(br.readLine());

            String event = st.nextToken();

            if (event.equals("push")) {
                int a = Integer.parseInt(st.nextToken());

                stack.add(a);
            } else if( event.equals("pop") ) {
                if( stack.isEmpty()) {
                    // 스택이 비어있으면 -1 출력
                    sb.append(-1).append("\n");
                } else {
                    // 스택이 비어있지 않으면 가장 위에 있는 정수를 빼고, 그 수를 출력
                    sb.append(stack.get(stack.size() - 1)).append("\n");
                    stack.remove(stack.size() - 1);
                }
            } else if( event.equals("size") ) {
                // 스택에 들어있는 정수의 개수를 출력
                sb.append(stack.size()).append("\n");
            } else if( event.equals("empty") ) {
                if( stack.isEmpty() ) {
                    // 스택이 비어있으면 1 출력
                    sb.append(1).append("\n");
                } else {
                    // 스택이 비어있지 않으면 0 출력
                    sb.append(0).append("\n");
                }
            } else if( event.equals("top")) {
                if( stack.isEmpty() ) {
                    // 스택이 비어있으면 -1 출력
                    sb.append(-1).append("\n");
                } else {
                    // 스택이 비어있지 않으면 가장 위에 있는 정수를 출력
                    sb.append(stack.get(stack.size() - 1)).append("\n");
                }
            }

        }

        System.out.print(sb.toString());
    }
}
