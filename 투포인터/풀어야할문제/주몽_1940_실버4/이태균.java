package 투포인터.풀어야할문제.주몽_1940_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] MATERIALS;

    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        MATERIALS = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            MATERIALS[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(MATERIALS);

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = MATERIALS[left] + MATERIALS[right];

            if (sum == M) {
                COUNT++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(COUNT);
    }
}