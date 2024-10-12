package 백트래킹.풀어야할문제.부분수열의합_1182_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static int N,S;
    static int count = 0;
    static int[] numbers;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0, 0);

        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void bfs(int index, int currentNumber) {

        if(index == N) {
            if (currentNumber == S) {
                count++;
            }
            return;
        }

        bfs(index + 1, currentNumber);
        bfs(index + 1, currentNumber + numbers[index]);
    }
}
