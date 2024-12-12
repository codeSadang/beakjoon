package 해시.완료된문제.나는야포켓몬마스터이다솜_1620_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 */
public class 황병수 {
    static int N,M;
    static HashMap<String, String> HashA = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            HashA.put(name, String.valueOf(i));
            HashA.put(String.valueOf(i), name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(HashA.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
