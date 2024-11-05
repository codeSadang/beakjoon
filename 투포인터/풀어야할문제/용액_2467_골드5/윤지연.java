package 투포인터.풀어야할문제.용액_2467_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    두 용액의 합이 0에 가장 가깝도록 만들기
     */

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

        twoPointer();

    }

    public static void twoPointer() {
        int s = 0;
        int e = N - 1;
        
        int bestS = 0;
        int bestE = N - 1;
        int minSum = Integer.MAX_VALUE;

        while (s < e) {
            int sum = liquids[s] + liquids[e];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                bestS = s;
                bestE = e;
            }

            if (sum < 0) {
                s++;
            } else {
                e--;
            }

        }
        System.out.println(liquids[bestS] + " " + liquids[bestE]);
    }
}
