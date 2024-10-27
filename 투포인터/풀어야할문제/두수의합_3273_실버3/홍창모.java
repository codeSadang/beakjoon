package 투포인터.풀어야할문제.두수의합_3273_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < n; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 시간 단축을 위해 sorting
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());

        System.out.print(twoPoint(arr, target));
    }

    public static int twoPoint(int[] arr, int target) {
        int answer = 0;

        int lt = 0, rt = n-1;
        while ( lt < rt ) {
            if( arr[lt] + arr[rt] == target ) answer++;
            if ( arr[lt] + arr[rt] <= target ) lt++;
            else rt--;
        }

        return answer;
    }
}
