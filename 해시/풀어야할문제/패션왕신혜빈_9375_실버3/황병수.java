package 해시.풀어야할문제.패션왕신혜빈_9375_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 황병수 {

    static int N;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            HashMap<String, Integer> mapA = new HashMap<>();

            int K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothName = st.nextToken();
                String clothType = st.nextToken();
                mapA.put(clothType, mapA.getOrDefault(clothType, 0) + 1);
            }

            int count = 1;
            for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
                count = count * (entry.getValue() + 1);
            }

            sb.append(count - 1).append("\n");
        }

        System.out.println(sb);
    }
}
