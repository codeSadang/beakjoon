package 백트래킹.풀어야할문제.카드놓기_5568_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 황병수 {

    static int N;
    static int K;
    static int[] CL;
    static boolean[] VISITED;
    public static Set<String> RL = new HashSet<>();

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static int solution() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());

        int[] cardList = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            cardList[i] = Integer.parseInt(bf.readLine());
        }

        backtracking(new StringBuilder(),0);

        return RL.size();
    }

    private static void backtracking(StringBuilder sb, int depth) {

        if (depth == K) {
            RL.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!VISITED[i]) {  // 아직 사용하지 않은 카드라면
                VISITED[i] = true;  // 카드를 사용한다고 표시
                sb.append(CL[i]);  // 숫자를 문자열에 추가

                backtracking(sb, depth + 1);

                VISITED[i] = false;
                sb.delete(sb.length() - String.valueOf(CL[i]).length(), sb.length());
            }
        }
    }
}
