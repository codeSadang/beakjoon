package 백트래킹.풀어야할문제.연산자끼워넣기_14888_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    static int N;
    static int[] numbers;
    static int[] operators; // operators[0]: +, operators[1]: -, operators[2]: *, operators[3]: /
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println("maxResult = " + maxResult);
        System.out.println("minResult = " + minResult);
    }


    static void dfs(int currentResult, int idx) {
        if (idx == N) {
            maxResult = Math.max(currentResult, maxResult);
            minResult = Math.min(currentResult, minResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0 :
                        dfs(currentResult + numbers[idx], idx + 1);
                        break;
                    case 1 :
                        dfs(currentResult - numbers[idx], idx + 1);
                        break;
                    case 2 :
                        dfs(currentResult * numbers[idx], idx + 1);
                        break;
                    case 3 :
                        // 부호 처리를 위한 나눗셈
                        if (currentResult < 0) {
                            dfs((-(Math.abs(currentResult) / numbers[idx])), idx + 1);
                        } else {
                            dfs(currentResult / numbers[idx], idx + 1);
                        }
                        break;
                }
                operators[i]++;
            }
        }
    }
}
