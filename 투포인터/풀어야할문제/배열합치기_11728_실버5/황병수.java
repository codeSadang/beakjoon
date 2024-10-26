package 투포인터.풀어야할문제.배열합치기_11728_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 정렬되어있는 두 배열 A,B가 주어진다.
 * 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 배열 A의 크기 N, B의 크기 m 이 주어진다.
 * 둘째 줄에는 A의 내용
 * 셋째 줄에는 B의 내용
 *
 * 첫째줄에 두 배열을 합친 후 정렬한 결과를 출력한다.
 */
public class 황병수 {

    static List<Long> A = new ArrayList<>();
    static List<Long> B = new ArrayList<>();
    static Long N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(Long.parseLong(st.nextToken()));
        }

        List<Long> result = new ArrayList<>();

        result.addAll(A);
        result.addAll(B);

//        System.out.println(result);

        result.sort(null);
        StringBuilder sb = new StringBuilder();

        for (long i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

//        result.sort(Collections.reverseOrder());
//        System.out.println(result);
//
//        Collections.sort(result, Collections.reverseOrder());
//        System.out.println(result);
//
//        Collections.sort(result);
//        System.out.println(result);

    }
}
