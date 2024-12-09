package 해시.풀어야할문제.패션왕신혜빈_9375_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 이태균 {

    public static int T;
    public static int N;

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int count = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                count = count * (entry.getValue() + 1);
            }

            SB.append(count - 1).append("\n");
        }

        System.out.println(SB.toString());
    }

}