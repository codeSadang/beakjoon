package 해시.풀어야할문제.패션왕신혜빈_9375_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 홍창모 {

    static int TEST_CASE, N;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TEST_CASE = Integer.parseInt(br.readLine());

        for( int i = 0; i < TEST_CASE; i++ ) {
            // 의상의 개수
            N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();

            for( int j = 0; j < N; j++ ) {
                st = new StringTokenizer(br.readLine());

                String clothes = st.nextToken();
                String kind = st.nextToken();

                // 같은 종류의 의상의 개수를 저장
                clothesMap.put(kind, clothesMap.getOrDefault(kind, 0) + 1);
            }

            int answer = 1;

            // 의상의 종류별로 의상의 개수를 곱해줌
            for( String key : clothesMap.keySet() ) {
                answer *= clothesMap.get(key) + 1;
            }

            // 아무것도 입지 않은 경우를 제외
            sb.append(answer - 1).append("\n");

        }

        System.out.print(sb.toString());

    }
}
