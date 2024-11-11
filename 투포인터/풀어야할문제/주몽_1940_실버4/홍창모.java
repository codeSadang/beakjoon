package 투포인터.풀어야할문제.주몽_1940_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n, m, answer;
    static int[] armor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        armor = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 0; i < n; i++ ) {
            armor[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        System.out.print(answer);
    }

    public static void twoPoint() {

        int lt = 0, rt = n-1;

        Arrays.sort(armor);

        while( lt < rt ) {
            int sum = armor[lt] + armor[rt];

            if( sum == m ) {
                answer++;
                lt++;
                rt--;
            } else if( sum > m ) {
                rt--;
            } else {
                lt++;
            }
        }
    }
}
