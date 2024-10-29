package 투포인터.풀어야할문제.먹을것인가먹힐것인가_7795_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이태균 {

    public static int T;
    public static int SIZE_A;
    public static int SIZE_B;
    public static int[] ARR_A;
    public static int[] ARR_B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            SIZE_A = Integer.parseInt(st.nextToken());
            SIZE_B = Integer.parseInt(st.nextToken());

            ARR_A = new int[SIZE_A];
            ARR_B = new int[SIZE_B];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE_A; j++) {
                ARR_A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE_B; j++) {
                ARR_B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ARR_A);
            Arrays.sort(ARR_B);

            int result = two_pointer();
            System.out.println(result);
        }
    }

    private static int two_roof() {
        int count = 0;
        for (int i = 0; i < SIZE_A; i++) {
            for (int j = 0; j < SIZE_B; j++) {
                if (ARR_A[i] > ARR_B[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int two_pointer() {
        int point_a = 0;
        int point_b = 0;
        int count = 0;

        while (point_a < SIZE_A) {
            while (point_b < SIZE_B && ARR_A[point_a] > ARR_B[point_b]) {
                point_b++;
            }

            count += point_b;
            point_a++;
        }

        return count;
    }

}