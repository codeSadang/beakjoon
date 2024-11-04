package 투포인터.풀어야할문제.용액_2467_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {
    static int n, min = Integer.MAX_VALUE;

    static int[] solution, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        solution = new int[n];

        // 두개의 용액만 담을 배열
        answer = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 0; i < n; i++ ) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        System.out.print( answer[0] + " " + answer[1] );
    }

    public static void twoPoint() {
        int lt = 0, rt = n-1;

        while( lt < rt ) {
            int sum = solution[lt] + solution[rt];

            if( Math.abs(sum) < min ) {
                min = Math.abs(sum);

                answer[0] = solution[lt];
                answer[1] = solution[rt];
            }

            if( sum >= 0 ) {
                rt--;
            } else {
                lt++;
            }
        }
    }
}
