package 투포인터.완료된문제.수열_2559_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int K;
    public static int[] ARR;
    public static int MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ARR = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        two_pointer();
        System.out.println(MAX);
    }

    private static void two_pointer() {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += ARR[i];
        }
        MAX = sum;

        for (int i = K; i < N; i++) {
            sum += ARR[i] - ARR[i - K];
            MAX = Math.max(MAX, sum);
        }
    }

}