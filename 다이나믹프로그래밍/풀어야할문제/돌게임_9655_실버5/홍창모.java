package 다이나믹프로그래밍.풀어야할문제.돌게임_9655_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int cnt = 0;

        while( N > 0 ) {
            if( N >= 3 ) {
                N -= 3;
                cnt++;
            } else {
                N -= 1;
                cnt++;
            }
        }

        if( cnt % 2 == 0 ) System.out.print("CY");
        else System.out.print("SK");

    }
}
