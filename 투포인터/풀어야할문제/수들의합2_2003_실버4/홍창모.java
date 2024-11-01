package 투포인터.풀어야할문제.수들의합2_2003_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(twoPoint(arr, M));
    }

    public static int twoPoint(int[] arr, int M) {
        int answer = 0;

        int lt = 0, rt = 0;
        int sum = 0;

        while(rt < arr.length ) {

            sum += arr[rt++];

            while( sum > M && lt < rt ) {
                sum -= arr[lt++];
            }

            if( sum == M ) {
            answer++;
            }

        }

        return answer;
    }
}
