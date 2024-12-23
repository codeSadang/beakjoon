package 그리디.풀어야할문제.회의실배정_1931_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {

    static Meeting[] meetings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetingNum = Integer.parseInt(br.readLine());
        meetings = new Meeting[meetingNum];
        StringTokenizer st;
        for (int i = 0; i < meetingNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }
        Arrays.sort(meetings, (a, b) -> a.end - b.end);

        int count = 1;
        int lastEndTime = meetings[0].end;

        for (int i = 1; i < meetingNum; i++) {
            if (meetings[i].start >= lastEndTime) {
                count++;
                lastEndTime = meetings[i].end;
            }
        }
        System.out.println(count);
    }

    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}