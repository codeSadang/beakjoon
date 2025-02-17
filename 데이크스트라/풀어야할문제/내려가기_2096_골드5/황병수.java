package 데이크스트라.풀어야할문제.내려가기_2096_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N줄에 0 이상 9 이하의 숫자가 3개씩 적혀있다.
 *
 */
public class 황병수 {

    static int[][] A = new int[2][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int middle = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            minA(left, middle, right);
            maxA(left, middle, right);
        }

        int minLeft = Math.min(A[0][0], A[0][1]);
        int minMiddle = Math.min(minLeft, A[0][2]);

        int maxLeft = Math.max(A[1][0], A[1][1]);
        int maxMiddle = Math.max(maxLeft, A[1][2]);

        System.out.println( maxMiddle +" " +minMiddle);

    }

    private static void minA(int left, int middle, int right) {
        int minLeft = Math.min(A[0][0], A[0][1]);
        int minMiddle = Math.min(minLeft, A[0][2]);
        int minRight = Math.min(A[0][1], A[0][2]);

        A[0][0] = minLeft + left;
        A[0][1] = minMiddle + middle;
        A[0][2] = minRight + right;

    }
    private static void maxA(int left, int middle, int right) {
        int maxLeft = Math.max(A[1][0], A[1][1]);
        int maxMiddle = Math.max(maxLeft, A[1][2]);
        int maxRight = Math.max(A[1][1], A[1][2]);

        A[1][0] = maxLeft + left;
        A[1][1] = maxMiddle + middle;
        A[1][2] = maxRight + right;
    }
}
