package 백트래킹.풀어야할문제.도영이가만든맛있는음식_2961_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * N개의 재료가 있다 .
 * 각 재료는 신맛과 쓴맛을 가지고 있다.
 *
 * 여러 재료를 이용해서 요리를 할 때
 * 신 맛은 사용한 재료의 곱
 * 쓴 맛은 사용한 재료의 합
 *
 * 적절히 재료를 섞어서 신맛과 쓴맛의 차이를 작게 만들어야 함
 * 적어도 재료를 하나 이상 사용해야 한다.
 *
 * 신맛과 쓴맛의 차이가 가장 작은 요리를 만드시오.
 */
public class 황병수2 {

    static int N;
    static int[][] material;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        material = new int[N][2];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            material[i][0] = Integer.parseInt(st.nextToken());
            material[i][1] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0,new ArrayList<>());
        System.out.println(result);
    }

    private static void backtracking(int index, int size, List<int[]> selected ) {

        if (index == N) {
            if (size > 0) {
                int sour = 1;
                int bitter = 0;
                for (int[] ints : selected) {
                    sour *= ints[0];
                    bitter += ints[1];
                }
                result = Math.min(result, Math.abs(sour - bitter));
            }
            return;
        }
        selected.add(material[index]);
        backtracking(index + 1, size + 1,  selected);

        selected.remove(selected.size() - 1);
        backtracking(index + 1, size, selected);
    }
}
