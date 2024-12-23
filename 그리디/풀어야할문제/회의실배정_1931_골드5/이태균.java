package 그리디.풀어야할문제.회의실배정_1931_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static List<int[]> MEETING_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            MEETING_LIST.add(new int[]{start, end});
        }

        MEETING_LIST.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int endTime = 0;
        int answer = 0;

        for (int[] meeting : MEETING_LIST) {
            if (meeting[0] >= endTime) {
                endTime = meeting[1];
                answer++;
            }
        }

        System.out.println(answer);
    }

}