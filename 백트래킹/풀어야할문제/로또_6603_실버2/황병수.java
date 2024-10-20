package 백트래킹.풀어야할문제.로또_6603_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 ~49 에서 6개 숫자를 고른다.
 *
 * 49수중 6개 이상의 수를 골라서 집합 s를 만든다음 그 수만 가지고서 번호를 선택
 */
public class 황병수 {

    static boolean[] visited;
    static int K;
    static int[] listA;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            visited = new boolean[K];
            listA = new int[K];
            for (int i = 0; i < K; i++) {
                listA[i] = Integer.parseInt(st.nextToken());
            }

            backtracking(0,0, "");
            result.append("\n");
        }
        System.out.println(result);
    }

    private static void backtracking(int count, int beforeIndex, String tempResult) {

        if (count == 6) {
            result.append(tempResult).append("\n");
            return;
        }

        for (int i = beforeIndex; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(count + 1, i,tempResult + listA[i] + " ");
                visited[i] = false;
            }
        }
    }
}
