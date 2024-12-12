package 해시.풀어야할문제.비밀번호찾기_17219_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 황병수 {
    static int N,M;
    static HashMap<String, String> mapA = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String password = st.nextToken();

            mapA.put(address, password);
        }

        for (int i = 0; i < M; i++) {
            sb.append(mapA.get(br.readLine())).append("\n");
        }


        System.out.println(sb);
    }
}
