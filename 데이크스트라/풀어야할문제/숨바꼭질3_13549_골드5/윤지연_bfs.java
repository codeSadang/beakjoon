package 데이크스트라.풀어야할문제.숨바꼭질3_13549_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연_bfs {
    static final int MAX = 100001;
    static int N, K;
    static int[] time; // 각 위치까지의 최소 시간을 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[MAX];
        Arrays.fill(time, Integer.MAX_VALUE);

        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);
        time[N] = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (cur == K) {
                return time[cur];
            }

            // 순간이동 (0초) - 우선 처리
            if (cur * 2 < MAX && time[cur * 2] > time[cur]) {
                time[cur * 2] = time[cur];
                deque.addFirst(cur * 2); // 덱의 앞에 추가
            }

            // 뒤로 걷기
            if (cur - 1 >= 0 && time[cur - 1] > time[cur] + 1) {
                time[cur - 1] = time[cur] + 1;
                deque.addLast(cur - 1); // 덱의 뒤에 추가
            }

            // 앞으로 걷기
            if (cur + 1 < MAX && time[cur + 1] > time[cur] + 1) {
                time[cur + 1] = time[cur] + 1;
                deque.addLast(cur + 1); // 덱의 뒤에 추가
            }
        }

        return -1;
    }
}