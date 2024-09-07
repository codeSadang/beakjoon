package 백트래킹.풀어야할문제.카드놓기_5568_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 상근이는 카드 n(4 ≤ n ≤ 10)장을 바닥에 나란히 놓고 놀고있다.
 * 각 카드에는 1이상 99이하의 정수가 적혀져 있다.
 * 상근이는 이 카드 중에서 k(2 ≤ k ≤ 4)장을 선택하고, 가로로 나란히 정수를 만들기로 했다.
 * 상근이가 만들 수 있는 정수는 모두 몇 가지일까?
 *
 * 예를 들어, 카드가 5장 있고, 카드에 쓰여 있는 수가 1, 2, 3, 13, 21라고 하자.
 * 여기서 3장을 선택해서 정수를 만들려고 한다.
 * 2, 1, 13을 순서대로 나열하면 정수 2113을 만들 수 있다.
 * 또, 21, 1, 3을 순서대로 나열하면 2113을 만들 수 있다.
 * 이렇게 한 정수를 만드는 조합이 여러 가지 일 수 있다.
 *
 * n장의 카드에 적힌 숫자가 주어졌을 때, 그 중에서 k개를 선택해서 만들 수 있는 정수의 개수를 구하는 프로그램을 작성하시오.
 */
public class 이태균 {

    public static int N;
    public static int K;
    public static int[] CARDS;
    public static boolean[] VISITED;
    public static Set<String> HS = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        CARDS = new int[N];
        VISITED = new boolean[N];

        for (int i = 0; i < N; i++) {
            CARDS[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, "");
        System.out.println(HS.size());
    }

    public static void dfs(int combineCount, String combineCard) {
        if (combineCount == K) {
            HS.add(combineCard);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (VISITED[i]) {
                continue;
            }

            VISITED[i] = true;
            dfs(combineCount + 1, combineCard + CARDS[i]);
            VISITED[i] = false;
        }

    }

}