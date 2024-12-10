package 해시.완료된문제.나는야포켓몬마스터이다솜_1620_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static StringBuilder sb = new StringBuilder();

    static HashMap<String, String> strKey = new HashMap<String, String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        strKey = new HashMap<String, String>();

        for( int i = 0; i < N; i++ ) {
            String str = br.readLine();

            // 1번부터 value값 설정
            strKey.put( str, String.valueOf(i+1) );
            strKey.put( String.valueOf(i+1), str);
        }
        
        for( int i = 0; i < M;  i++ ) {
            String key = br.readLine();

            sb.append( strKey.get( key) ).append("\n");
        }

        System.out.println(sb.toString());
    }
}
