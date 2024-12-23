package 그리디.풀어야할문제.설탕배달_2839_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int answer = 0;

        while ( N > 0 ) {
            if( N % 5 == 0 ) {
                N -= 5;
                answer++;
            } else if( N % 3 == 0 ) {
                N -= 3;
                answer++;
            } else if( N > 5 ) {
                N -= 5;
                answer++;
            } else {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }
}
