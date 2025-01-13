package 다이나믹프로그래밍.풀어야할문제.부녀회장이될테야_2775_브론즈1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 반상회 참석하는것을 좋아하는 주희는 이번 기회에 부녀회장이 되고싶다
 * a층에 b호에 살려면
 * 자신의 a-1층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
 *
 * 아파트에 비어있는 집이 없고, 모든 주민이 계약조건을 지키고 있다.
 * 주어지는 양의 정수k와 n에 대해
 * k층에 n호에는 몇명이 살고있는지 출력하라
 *
 * 단, 아파트에는 0층부터있고 각층에는 1호부터 있으면 0층의 i호에는 i명이 산다.
 *
 */
public class 황병수 {

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            map = new int[k+1][n+1];
            // k층 n호

            // 0층 1호 = 1명 1층 1호 = 1명 2층 1호 = 2명
            // 0층 2호 = 2명 1층 2호 = 3명 2층 2호 = 4명
            // 0층 3호 = 3명 1층 3호 = 6명 2층 3호 = 10명

            for (int j = 1; j <= n; j++) {
                map[0][j] = j;
            }

            calcMap(k, n);
            System.out.println(map[k][n]);
        }


    }
    public static void calcMap(int k, int n) {
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] += map[i-1][j] + map[i][j-1];
            }
        }
    }
}
