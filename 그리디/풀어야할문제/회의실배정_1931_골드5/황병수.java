package 그리디.풀어야할문제.회의실배정_1931_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class 황병수 {

    static int N;
    static int LastTime;
    static int[][] ListA;
    static Boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ListA = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            ListA[i][0] = startTime;
            ListA[i][1] = endTime;
        }

        Arrays.sort(ListA, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (ListA[i][0] >= LastTime) {
                LastTime = ListA[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
