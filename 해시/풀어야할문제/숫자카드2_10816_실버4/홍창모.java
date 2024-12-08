package 해시.풀어야할문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> numberCard = new HashMap<String, Integer>();

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            String key = st.nextToken();

            numberCard.put(key, numberCard.getOrDefault(key, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < M; i++ ) {
            String target = st.nextToken();

            if( numberCard.containsKey(target) ) {
                sb.append( numberCard.get(target) ).append( ' ' );
            } else {
                sb.append( 0 ).append( ' ' );
            }
        }

        System.out.print(sb.toString());
    }
}
