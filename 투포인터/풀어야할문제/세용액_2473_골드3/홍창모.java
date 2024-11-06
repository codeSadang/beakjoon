package 투포인터.풀어야할문제.세용액_2473_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n;
    static long min = Long.MAX_VALUE;
    static long[] solution, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        solution = new long[n];
        answer = new long[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < n; i++ ) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        Arrays.sort(answer);

        System.out.print( answer[0] + " " + answer[1] + " " + answer[2] );
    }

    public static void twoPoint() {

        // 오름차순 정렬
        Arrays.sort(solution);

        // 시작끝을 제외한 나머지를 탐색
        for( int i = 0; i < n-2; i++ ) {
            int lt = i+1;
            int rt = n-1;

            while( lt < rt ) {
                long sum = solution[i] + solution[lt] + solution[rt];

                if( Math.abs(sum) < min ) {
                    min = Math.abs(sum);

                    answer[0] = solution[i];
                    answer[1] = solution[lt];
                    answer[2] = solution[rt];

                    if( sum == 0 ) {
                        break;
                    }
                }

                if( sum > 0 ) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }
    }
}
