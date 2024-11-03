package 투포인터.완료된문제.귀여운라이언_15565_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int K;
    static int[] D;
    static Integer result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        // pointer
        int left = 0;
        int right = 0;
        int lion = 0;

        while (right < N) {
            if (D[right] == 1) lion++;

            while (lion >= K) {
                result = Math.min(result, right - left + 1);
                if (D[left] == 1) {
                    lion--;
                }
                left++;
            }
            right++;
        }

        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }
}

