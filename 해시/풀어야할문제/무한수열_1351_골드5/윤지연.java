package 해시.풀어야할문제.무한수열_1351_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    * 재귀 사용시 결과값을 저장해서 사용하자.
    * memoization 기법*/

    static long N, P, Q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map.put(0L, 1L);

        System.out.println(memoization(N));
    }

    static long memoization(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        long firstKey = n/P;
        long secondKey = n/Q;

        long result = memoization(firstKey) + memoization(secondKey);

        map.put(n, result);
        return result;
    }
}
