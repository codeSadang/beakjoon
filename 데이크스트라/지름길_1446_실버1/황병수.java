package 데이크스트라.지름길_1446_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    static int testCase;
    static int destination;
    static int[] P;
    static List<int[]> shortcuts = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         testCase = Integer.parseInt(st.nextToken());
         destination = Integer.parseInt(st.nextToken());

        P = new int[destination + 1]; // 여기에는 위치에서 최소값을 저장
        Arrays.fill(P, Integer.MAX_VALUE);
        P[0] = 0;

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (next > destination) continue; // 도착지를 초과하는 지름길은 무시
            if (next - current <= distance) continue; // 지름길이 더 길면 의미 없음

            shortcuts.add(new int[]{current, next, distance});
        }

        // 도착 지점(next) 기준으로 오름차순 정렬
        shortcuts.sort(Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i <= destination; i++) {

            if (i > 0) {
                P[i] = Math.min(P[i], P[i - 1] + 1); // 기본 도로 이동
            }

            for (int[] shortcut : shortcuts) {
                int current = shortcut[0];
                int next = shortcut[1];
                int distance = shortcut[2];

                if (i == current) { // 현재 위치가 지름길의 시작점이라면
                    P[next] = Math.min(P[next], P[current] + distance);
                }
            }
        }

        System.out.println(P[destination]); // 최종 도착지 최소 거리 출력
    }
}