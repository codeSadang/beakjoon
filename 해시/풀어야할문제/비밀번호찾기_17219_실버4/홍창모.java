package 해시.풀어야할문제.비밀번호찾기_17219_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, String> passwordMap = new HashMap<String, String>();

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            passwordMap.put(site, password);
        }

        for( int i = 0; i < M; i++ ) {
            String site = br.readLine();

            sb.append(passwordMap.get(site)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
