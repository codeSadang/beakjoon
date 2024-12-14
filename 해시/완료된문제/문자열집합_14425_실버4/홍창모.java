package 해시.완료된문제.문자열집합_14425_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<String>();

        for( int i = 0; i < N; i++ ) {
            set.add(br.readLine());
        }

        int answer = 0;

        for( int i = 0; i < M; i++ ) {
            if( set.contains(br.readLine()) ) answer++;
        }

        System.out.println(answer);
    }
}
