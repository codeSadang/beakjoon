package 투포인터.풀어야할문제.수들의합5_2018_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    핵심
    - 자연수 N 을 연속된 자연수 합으로 나타낼 수 있는 가지수를 출력한다.

    수도코드
    1. 입력처리
        1. 자연수 N을 입력받는다.
        2. 1부터 N 까지 입력된 배열을 만든다.
    2. 배열탐색
        2개의 포인터를 만들어 1-2의 배열을 탐색한다.
        1. s, e 모두 0부터 시작
        2. s부터 e까지 합이 N인 경우 카운트한다.
        3. 예외 - 단일값도 카운트에 포함한다.
    3. 출력
     */

    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int s = 1;
        int e = 1;
        int sum = 1;

        while (e <= N) {
            if (sum == N ) {
                count++;
                sum -= s;
                s++;
            } else if (sum < N) {
                e++;
                sum += e;
            } else {
                sum -= s;
                s++;
            }
        }
        System.out.println(count);
    }
}
