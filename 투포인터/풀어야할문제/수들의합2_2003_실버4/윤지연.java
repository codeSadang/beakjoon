package 투포인터.풀어야할문제.수들의합2_2003_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    분석
    - 수열의 부분합이 M이 되는 경우의 수를 출력한다.
    1. 입력처리
        1. N, M
        2. count(경우의 수)
    2. 부분합 구하기
        1. 탐색 위치를 설정할 두 개의 포인터(s,e)를 설정한다.
        2. s부터 e까지 합계를 구한다.
        3. 합계가 M 이면 count를 증가시킨다.
        4. 합계가 M 미만이면 현재 끝점 합계에 더하고, e 포인터 증가
        5. 합계가 M 초과면 현재 시작점을 합계에서 빼고, s 포인터 증가
     */

    static int N;
    static int M;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int sum = 0;

        while (e < N) {
            if (sum < M) {
                if (e == N) break;
                sum += arr[e++];
            } else if (sum == M) {
                count++;
                sum -= arr[s++];
            } else {
                sum -= arr[s++];
            }
        }
        System.out.println(count);
    }
}
