package 투포인터.완료된문제.두수의합_3273_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[] ARR;
    public static int X;

    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ARR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(ARR);

        two_pointer();

        System.out.println(COUNT);
    }

    private static void two_pointer() {
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = ARR[left] + ARR[right];

            if (sum == X) {
                COUNT++;
                left++;
                right--;
            } else if (sum < X) {
                left++;
            } else {
                right--;
            }
        }
    }
}