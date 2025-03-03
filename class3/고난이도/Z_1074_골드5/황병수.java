package class3.고난이도.Z_1074_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2^n 2차원 배열을 z모양으로 탐색하려고 한다.
 */
public class 황병수 {

    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N); // 배열 크기 (2^N × 2^N)
        solve(0, 0, size);

        System.out.println(count);
    }

    static void solve(int x, int y, int size) {
        if (size == 1) return; // 크기가 1이면 종료

        int half = size / 2;

        if (r < x + half && c < y + half) { // 1사분면 (좌상)
            solve(x, y, half);
        } else if (r < x + half && c >= y + half) { // 2사분면 (우상)
            count += half * half;
            solve(x, y + half, half);
        } else if (r >= x + half && c < y + half) { // 3사분면 (좌하)
            count += 2 * half * half;
            solve(x + half, y, half);
        } else { // 4사분면 (우하)
            count += 3 * half * half;
            solve(x + half, y + half, half);
        }
    }
}
