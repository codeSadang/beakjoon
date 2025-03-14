package class4.풀어야할문제.문자열폭발_9935_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 이태균 {

    public static String STR;
    public static String BOMB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        STR = br.readLine();
        BOMB = br.readLine();

        char[] charList = STR.toCharArray();
        char[] bombList = BOMB.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : charList) {
            stack.push(c);

            if (stack.size() >= bombList.length) {
                boolean isBomb = true;

                // 스택의 최상단 부분과 폭발 문자열 비교
                for (int i = 0; i < bombList.length; i++) {
                    if (stack.get(stack.size() - bombList.length + i) != bombList[i]) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발 문자열이 발견되면 스택에서 제거
                if (isBomb) {
                    for (int i = 0; i < bombList.length; i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char ch : stack) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}