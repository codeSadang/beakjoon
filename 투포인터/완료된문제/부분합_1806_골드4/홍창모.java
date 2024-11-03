package 투포인터.완료된문제.부분합_1806_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < n; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(twoPoint(arr, n, s));
    }

    public static int twoPoint(int[] arr,int n, int s) {
        int answer = Integer.MAX_VALUE;

        int lt = 0, rt = 0, sum = 0;
        while(rt < n) {
            sum += arr[rt++];

            while ( sum >= s ) {
                answer = Math.min( answer, rt -lt );
                sum -= arr[lt];
                lt++;
            }
        }

        if( answer == Integer.MAX_VALUE ) answer = 0;

        return answer;
    }
}
