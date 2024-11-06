package 투포인터.풀어야할문제.주몽_1940_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int M;
    static int[] materials;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        materials = new int[N];

        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);
        twoPointer();
    }

    public static void twoPointer() {
        int s = 0, e = N - 1, count = 0;

        while (s < e) {
            int sum = materials[s] + materials[e];

            if (sum > M) {
                e--;
            } else if (sum < M) {
                s++;
            } else {
                count++;
                s++;
            }
        }
        System.out.println(count);
    }

}
