package 백트래킹.풀어야할문제.부분수열의합_1182_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int N,S;
    static int[] list;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] =  Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);

        // 부분 배열 합이 0인경우 0 제외
        if (S == 0) {
            result--;
        }

        System.out.println(result);
    }

    private static void backtracking(int index, int sum) {

        if (index == N) {
            if (S == sum) {
                result++;
            }
            return;
        }

        // 포함하지 않고 넘어가는 경우
        backtracking(index + 1, sum);

        // 포함하고 넘어가는 경우
        backtracking(index + 1, sum + list[index]);
    }
}
