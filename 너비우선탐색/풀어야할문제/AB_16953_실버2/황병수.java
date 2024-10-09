package 너비우선탐색.풀어야할문제.AB_16953_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 황병수 {
        static long A,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(bfs(A, B));
    }

    static long bfs(long now, long target) {
        ArrayDeque<long[]> queue = new ArrayDeque<>();
        HashSet<Long> visited = new HashSet<>();

        queue.add(new long[]{now, 1});
        visited.add(now);

        while (!queue.isEmpty()) {
            long[] curr = queue.poll();
            long currNow = curr[0];
            long currCnt = curr[1];

            if(currNow == target) {
                return currCnt;
            }

            long[] nextPositions = new long[]{currNow * 2 , currNow * 10 + 1};

            for (long nextPosition : nextPositions) {
                if (!visited.contains(nextPosition) && nextPosition <= target) {
                    queue.add(new long[]{nextPosition, currCnt + 1});
                    visited.add(nextPosition);
                }
            }
        }

        return -1;
    }
}
