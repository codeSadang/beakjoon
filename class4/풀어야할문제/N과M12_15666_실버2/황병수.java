package class4.풀어야할문제.N과M12_15666_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    static TreeSet<Integer> set;
    static int N,M;
    static int[] sequence;
    static ArrayList<Integer> sortedList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new TreeSet<>(); // 중복 없이 자동 정렬되는 자료구조

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        sortedList = new ArrayList<>(set);
        sequence = new int[M];

        backtrack(0, 0);
    }

    private static void backtrack(int startIndex, int depth) {
        if (depth == M) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = startIndex; i < sortedList.size(); i++) {
            sequence[depth] = sortedList.get(i);
            backtrack(i, depth + 1); // 중복 허용이므로 i 그대로 전달 (i + 1이 아님)
        }
    }
}
