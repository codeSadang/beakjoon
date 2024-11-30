package 해시.풀어야할문제.듣보잡_1764_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int N;
    public static int M;

    public static Set<String> DEAF;
    public static List<String> RESULT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DEAF = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            DEAF.add(br.readLine());
        }

        RESULT = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String blind = br.readLine();
            if (DEAF.contains(blind)) {
                RESULT.add(blind);
            }
        }

        Collections.sort(RESULT);

        System.out.println(RESULT.size());
        for (String s : RESULT) {
            System.out.println(s);
        }
    }

}