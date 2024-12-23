package 백트래킹.풀어야할문제.N과M3_15651_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int M;
    static List<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 입력처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtrack();
        System.out.println(sb.toString());
    }

    public static void backtrack() {
        // 기저조건
        if (result.size() == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result.add(i);
            backtrack();
            result.remove(result.size() - 1);
        }
    }
}
