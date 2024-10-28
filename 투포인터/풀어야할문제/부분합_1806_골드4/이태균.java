package 투포인터.풀어야할문제.부분합_1806_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int S;

    public static int[] ARR;
    public static int LENGTH = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        ARR = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < N) {
            sum += ARR[right++];

            while (sum >= S) {
                LENGTH = Math.min(LENGTH, right - left);
                sum -= ARR[left];
                left++;
            }
        }

        if (LENGTH == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(LENGTH);
        }
    }
}