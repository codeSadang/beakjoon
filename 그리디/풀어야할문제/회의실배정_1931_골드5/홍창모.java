package 그리디.풀어야할문제.회의실배정_1931_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N;

    static int[][] MEETING_TIME;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 회의 수

        int answer = 0;

        MEETING_TIME = new int[N][2];

        for( int i = 0; i < N; i++ ) {
           st = new StringTokenizer(br.readLine());

            MEETING_TIME[i][0] = Integer.parseInt(st.nextToken());
            MEETING_TIME[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료시간 내림차순 정렬
        Arrays.sort(MEETING_TIME, (o1, o2) -> {
            if( o1[1] == o2[1] ) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        /*for( int i = 0; i < N; i++ ) {
            System.out.println(Arrays.toString(MEETING_TIME[i]));
        }*/

        int end = 0;
        for( int i = 0; i < N; i++ ) {
            if( end <= MEETING_TIME[i][0] ) {
                end = MEETING_TIME[i][1];
                answer++;
            }
        }

        System.out.println(answer);

    }
}
