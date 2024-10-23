package 백트래킹.풀어야할문제.N과M2_15650_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int M;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        // 입력처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new ArrayList<>();

        backtrack(1);
    }

    public static void backtrack(int start) {
        // 기저조건
        if (result.size() == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            result.add(i);
            backtrack(i + 1);
            result.remove(result.size() - 1);
        }
    }
}
