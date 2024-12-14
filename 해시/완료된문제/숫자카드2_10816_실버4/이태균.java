package 해시.완료된문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static Map<Integer, Integer> N_MAP;
    public static int M;

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N_MAP = new HashMap<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            N_MAP.put(card, N_MAP.getOrDefault(card, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int count = Integer.parseInt(st.nextToken());
            SB.append(N_MAP.getOrDefault(count, 0)).append(" ");
        }

        System.out.println(SB.toString().trim());
    }
}