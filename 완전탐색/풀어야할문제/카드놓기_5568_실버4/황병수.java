package 완전탐색.풀어야할문제.카드놓기_5568_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 황병수 {

    static int N;
    static int K;

    static HashSet<String> resultList;

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static int solution() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());

        int[] cardList = new int[N];
        resultList = new HashSet<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            cardList[i] = Integer.parseInt(bf.readLine());
        }

        backtracking(new StringBuilder(), cardList,visited,0);

        return resultList.size();
    }

    private static void backtracking(StringBuilder sb, int[] cardList, boolean[] visited, int depth) {
        if (depth == K) {
            resultList.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {  // 아직 사용하지 않은 카드라면
                visited[i] = true;  // 카드를 사용한다고 표시
                sb.append(cardList[i]);  // 숫자를 문자열에 추가

                // 다음 깊이 탐색
                backtracking(sb, cardList, visited, depth + 1);

                // 탐색이 끝난 후 원상복구 (백트래킹)
                visited[i] = false;
                sb.delete(sb.length() - String.valueOf(cardList[i]).length(), sb.length());
            }
        }
    }
}
