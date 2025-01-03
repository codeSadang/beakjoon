package 정렬.풀어야할문제.ATM_11399_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> times = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(times);

        int totalTime = 0;
        int cumulativeTime = 0;

        for (int time : times) {
            cumulativeTime += time;
            totalTime += cumulativeTime;
        }

        System.out.println(totalTime);
    }

}