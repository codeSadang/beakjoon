package 백트래킹.풀어야할문제.계란으로계란치기_16987_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static List<int[]> eggs;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eggs = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            eggs.add(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])});
        }


        backtracking(0, 0);

        System.out.println(result);
    }

    private static void backtracking(int hand, int count) {


        if (hand == N || count == N) {
            result = Math.max(result, count);
            return;
        }

        if (eggs.get(hand)[0] <= 0) {
            backtracking(hand + 1, count);
            return;
        }

        boolean hasHit = false; // 유효한 타격 여부를 확인하는 변수
        for (int target = 0; target < N; target++) {
            if (hand != target && eggs.get(target)[0] > 0) {
                hasHit = true; // 타격할 계란이 존재함을 표시

                eggs.get(hand)[0] -= eggs.get(target)[1];
                eggs.get(target)[0] -= eggs.get(hand)[1];

                int brokenCount = 0;
                if (eggs.get(hand)[0] <= 0) brokenCount++;
                if (eggs.get(target)[0] <= 0) brokenCount++;

                backtracking(hand + 1 , count + brokenCount);

                eggs.get(hand)[0] += eggs.get(target)[1];
                eggs.get(target)[0] += eggs.get(hand)[1];
            }
        }

        // 타격할 계란이 없으면 다음 계란으로 이동
        if (!hasHit) {
            backtracking(hand + 1, count);
        }
    }
}
