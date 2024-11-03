package 투포인터.완료된문제.수열_2559_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print( twoPoint(arr, K) );
    }

    public static int twoPoint( int[] arr, int k ) {
        int answer = 0;
        int sum =0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for( int i = k; i < arr.length; i++ ) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
