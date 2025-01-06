package 자료구조.풀어야할문제.괄호_9012_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for( int i = 0; i < N; i++ ) {
            String str = br.readLine();

            if( isVPS(str) ) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    public static boolean isVPS( String str ) {
        Stack<Character> stack = new Stack<>();

        for( int i = 0; i < str.length(); i++ ) {
            char c = str.charAt(i);

            if( c == '(' ) {
                stack.push(c);
            } else {
                if( stack.isEmpty() ) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
