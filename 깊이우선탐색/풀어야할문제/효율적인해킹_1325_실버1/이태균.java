package 깊이우선탐색.풀어야할문제.효율적인해킹_1325_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다.
 * 이 회사는 N개의 컴퓨터로 이루어져 있다.
 * 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
 * <p>
 * 이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데,
 * A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
 * <p>
 * 이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때,
 * 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
 */
public class 이태균 {

    public static int N;
    public static int M;
    public static List<List<Integer>> COMPUTER_LIST;
    public static boolean[] VISITED;
    public static int[] HACKING_COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        COMPUTER_LIST = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            COMPUTER_LIST.add(new ArrayList<>());
        }
        VISITED = new boolean[N + 1];
        HACKING_COUNT = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            COMPUTER_LIST.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            VISITED = new boolean[N + 1];
            dfs(i, i);
        }

        int maxHackingCount = Arrays.stream(HACKING_COUNT).max().getAsInt();

        System.out.println(Arrays.toString(HACKING_COUNT));

        for (int i = 0; i <= N; i++) {
            if (maxHackingCount == HACKING_COUNT[i]) {
                System.out.println(i);
            }
        }
    }

    private static void dfs(int start, int idx) {
        VISITED[start] = true;
        HACKING_COUNT[idx]++;

        for (int i : COMPUTER_LIST.get(start)) {
            if (!VISITED[i]) {
                dfs(i, idx);
            }
        }
    }

}