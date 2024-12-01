package 해시.풀어야할문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N, M;
    static Map<Integer, Integer> comparison = new HashMap<>();
    static int[] control;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int inputValue = Integer.parseInt(st.nextToken());
            comparison.put(inputValue, comparison.getOrDefault(inputValue, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        control = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            control[j] = Integer.parseInt(st.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        for (int num : control) {
            if (comparison.containsKey(num)) {
                answer.append(comparison.get(num)).append(" ");
            } else {
                answer.append("0 ");
            }
        }
        System.out.println(answer.toString().trim());
    }
}
