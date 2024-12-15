package 해시.완료된문제.무한수열_1351_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 이태균 {

    public static long N;
    public static long P;
    public static long Q;

    public static Map<Long, Long> MAP = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        MAP.put(0L, 1L);

        long result = memoization(N);
        System.out.println(result);
    }

    public static long memoization(long n) {
        if (MAP.containsKey(n)) {
            return MAP.get(n);
        }

        long first = n / P;
        long second = n / Q;

        long result = memoization(first) + memoization(second);

        MAP.put(n, result);
        return result;
    }

}