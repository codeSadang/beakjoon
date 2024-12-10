package 해시.완료된문제.듣보잡_1764_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홍창모 {

    static ArrayList<String> arr = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한
        HashSet<String> set1 = new HashSet<String>();

        for( int i = 0; i < N; i++ ) {
            set1.add(br.readLine());
        }

        for( int i = 0; i < M; i++ ) {
            // 보도 못한
            String key = br.readLine();
            if( set1.contains(key) ) {
                arr.add(key);
            }
        }

        arr.sort(null);

        System.out.println(arr.size());
        for( int i = 0; i < arr.size(); i++ ) {
            System.out.println(arr.get(i));
        }
    }
}
