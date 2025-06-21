package 백트래킹.풀어야할문제.BookShelf2_6148_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int B;
    public static int[] H_I;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 책의 개수
        B = Integer.parseInt(st.nextToken()); // 필요한 최소 높이

        H_I = new int[N];
        for (int i = 0; i < N; i++) {
            H_I[i] = Integer.parseInt(br.readLine());
        }

        backtracking(0, 0);

        System.out.println(min);
    }

    // 백트래킹을 이용한 모든 조합 탐색
    private static void backtracking(int index, int sum) {
        // 현재 합이 B 이상이면 차이 갱신
        if (sum >= B) {
            min = Math.min(min, sum - B);
            return;
        }

        // 모든 책을 검사했으면 종료
        if (index == N) {
            return;
        }

        // 현재 책을 선택하는 경우
        backtracking(index + 1, sum + H_I[index]);

        // 현재 책을 선택하지 않는 경우
        backtracking(index + 1, sum);
    }
}