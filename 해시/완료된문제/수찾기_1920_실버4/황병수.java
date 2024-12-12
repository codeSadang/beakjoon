package 해시.완료된문제.수찾기_1920_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N개의 정수가 주어졌을 떄 이 안에 x라는 정수가 존재하는지 알아내는 프로그램 작성
 */
public class 황병수 {

    static int N, M;
    static HashSet<Integer> setA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        setA = new HashSet<>();

        // ListA에 있는 값을 HashSet에 담기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (setA.contains(number)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
