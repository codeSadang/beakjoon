package 해시.완료된문제.문자열집합_14425_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static Set<String> S_SET;

    public static int RESULT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        S_SET = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            S_SET.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (S_SET.contains(br.readLine())) {
                RESULT++;
            }
        }

        System.out.println(RESULT);
    }

}