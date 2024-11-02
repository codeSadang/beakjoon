package 투포인터.풀어야할문제.귀여운라이언_15565_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int K;
    public static int[] DOLL_LIST;

    public static int COUNT = 0;
    public static int RESULT = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        DOLL_LIST = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            DOLL_LIST[i] = Integer.parseInt(st.nextToken());
        }

        two_pointer();

        if (RESULT == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(RESULT);
        }
    }

    private static void two_pointer() {
        int left = 0;
        int right = 0;

        while (right < N) {
            if (DOLL_LIST[right] == 1) {
                COUNT++;
            }

            while (COUNT >= K) {
                RESULT = Math.min(RESULT, right - left + 1);

                if (DOLL_LIST[left] == 1) {
                    COUNT--;
                }

                left++;
            }

            right++;
        }
    }
}