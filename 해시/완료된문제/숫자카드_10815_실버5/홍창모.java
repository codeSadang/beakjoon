package 해시.완료된문제.숫자카드_10815_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 홍창모 {


    static int N, M;
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        HashSet<Integer> numberCard = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            numberCard.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < M; i++ ) {
            int key = Integer.parseInt(st.nextToken());

            if( numberCard.contains(key) ) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb.toString());
    }
}
