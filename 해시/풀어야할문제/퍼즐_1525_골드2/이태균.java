package 해시.풀어야할문제.퍼즐_1525_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static Map<String, Integer> MAP = new HashMap<>();
    public static int[] DX = {-1, 0, 1, 0};
    public static int[] DY = {0, -1, 0, 1};

    public static String RESULT = "123456780";

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                int n = Integer.parseInt(st.nextToken());
                SB.append(n);
            }
        }

        int answer = bfs(SB.toString());
        System.out.println(answer);
    }

    public static int bfs(String init) {
        Queue<String> q = new LinkedList<>();
        q.add(init);

        while (!q.isEmpty()) {
            String pos = q.poll();
            int move = MAP.get(pos);
            int empty = pos.indexOf('0');
            int px = empty % 3;
            int py = empty / 3;

            if (pos.equals(RESULT)) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + DX[i];
                int ny = py + DY[i];

                if (nx < 0 || ny < 0 || nx > 2 || ny > 2) continue;

                int nPos = ny * 3 + nx;
                char ch = pos.charAt(nPos);
                String next = pos.replace(ch, 'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if (!MAP.containsKey(next)) {
                    q.add(next);
                    MAP.put(next, move + 1);
                }
            }
        }

        return -1;
    }

}