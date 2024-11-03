package 투포인터.완료된문제.귀여운라이언_15565_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n, k;

    static int answer = Integer.MAX_VALUE;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < n; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);
    }

    public static void twoPoint() {
        int lt = 0, rt =0;

        int sum = 0, len = 0;

        while ( rt < n ) {

            if( arr[lt] == 2 ) {
                lt++;
            }

            if( arr[rt] == 1 ) {
                sum++;
            }

            if( sum >= k ) {
                len = rt - lt + 1;
                answer = Math.min(answer, len);

                int tmp = lt;
                while( tmp < n && lt < rt ) {
                    if( arr[tmp] == 1 && tmp > lt ) {
                        sum--;
                        lt = tmp;
                        rt++;
                        break;
                    }
                    tmp++;
                }

            } else {
                rt++;
            }


        }

        if( sum >= k ) answer = Math.min(answer, rt - lt + 1);
    }
}
