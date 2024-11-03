package 투포인터.완료된문제.수들의합5_2018_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // target
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        for( int i = 1; i <= n; i++ ) {
            arr[i] = i;
        }

        System.out.print(twoPoint(n, arr));

    }

    public static int twoPoint(int n, int[] arr) {
        int answer = 0;

        int target = n;

        int start=1,end=1,sum = 0;

        while ( start <= end && end <= target ) {

            if( sum + arr[end] < target ) {
                sum += arr[end];
                end++;
            }

            if( sum + arr[end] > target ) {
                sum-= arr[start];
                start++;
            }

            if( sum + arr[end] == target ) {
                answer++;
                sum -= arr[start];
                start++;
            }
        }

        return answer;
    }
}
