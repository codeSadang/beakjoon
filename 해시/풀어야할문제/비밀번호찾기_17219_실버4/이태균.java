package 해시.풀어야할문제.비밀번호찾기_17219_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String loginId = st.nextToken();
            map.put(url, loginId);
        }

        for (int i = 0; i < M; i++) {
            String findUrl = br.readLine();
            if (map.containsKey(findUrl)) {
                System.out.println(map.get(findUrl));
            }
        }
    }

}