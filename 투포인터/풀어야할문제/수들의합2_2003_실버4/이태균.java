package 투포인터.풀어야할문제.수들의합2_2003_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] ARR;

    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ARR = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < N) {
            if (sum >= M) {
                sum -= ARR[left++];
            }  else {
                sum += ARR[right++];
            }

            if (sum == M) {
                COUNT++;
            }
        }

        System.out.println(COUNT);
    }

}