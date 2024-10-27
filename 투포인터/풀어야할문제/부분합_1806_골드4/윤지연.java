package 투포인터.풀어야할문제.부분합_1806_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    1. 입력처리
    2. 부분합 구하기
        1. 두 포인터(s,e)는 0에서 함께 시작한다.
        2. 현재 위치 합계가 S 미만이라면 e 포인터 1증가, 합계에 현재 끝값을 더한다.
        3. 현재 위치 합계가 S 이상이면
            1. 길이 측정 후 min값에 할당
            2. 합계에서 현재 시작값을 빼고, s 포인터 1증가
    3. 예외처리
        1. 2에서 구하는 값이 없을 경우 0을 출력한다.
    4. 출력
     */
    static int N;
    static int S;
    static int[] array;
    static Integer minLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 1. 입력처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 부분합 구하기
        // 포인터 선언 및 초기화
        int s = 0;
        int e = 0;
        int sum = 0;

        while (e < N) {
            sum += array[e++];
            while (S <= sum) {
                minLength = Math.min(minLength, e-s);
                sum -= array[s++];
            }
        }
        // 3. 예외처리
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
