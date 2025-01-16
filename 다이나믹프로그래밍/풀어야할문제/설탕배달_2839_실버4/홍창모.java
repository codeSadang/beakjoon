package 다이나믹프로그래밍.풀어야할문제.설탕배달_2839_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 설탕의 총량
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while( n >= 0 ) {

            if( n % 5 == 0 ) {
                cnt += n / 5;

                System.out.println(cnt);
                return;
            }

            n -= 3;
            cnt++;
        }

        System.out.println(-1);
    }
}
