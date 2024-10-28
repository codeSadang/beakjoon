package 투포인터.풀어야할문제.두수의합_3273_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    포인터 이동하는 경우
    - s: x 만족 또는 끝까지 간 경우 증가
    - e: 시작은  s + 1, x 만족 안하면 증가

     */

    static int n;
    static int x;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x =  Integer.parseInt(st.nextToken());

        // pointer
        int s = 0;
        int sum = 0;

        while (true) {
            if (s > n) break;
            for (int i = s; i < n - 1; i++) {
                sum = arr[s] + arr[i+1];
                if (sum == x) {
                    count++;
                    break;
                }
            }
            s++;
        }
        System.out.println(count);
    }
}
