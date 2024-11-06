package 투포인터.풀어야할문제.세용액_2473_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int[] liquids;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        liquids = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);
        twoPointer();
    }

    public static void twoPointer() {
        int s, e;
        long minLength = Long.MAX_VALUE;
        int bestP = 0, bestS = 0, bestE = 0;

        for (int i = 0; i < N - 2; i++) {
            s = i + 1;
            e = N - 1;
            while (s < e) {
                long sum = (long) liquids[i] + liquids[s] + liquids[e];

                if (Math.abs(sum) < Math.abs(minLength)) {
                    minLength = sum;
                    bestP = i;
                    bestS = s;
                    bestE = e;
                }

                if (sum < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        System.out.println(liquids[bestP] + " " + liquids[bestS] + " " + liquids[bestE]);
    }
}
