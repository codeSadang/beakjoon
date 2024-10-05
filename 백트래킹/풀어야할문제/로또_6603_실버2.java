package 백트래킹.풀어야할문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또_6603_실버2 {

    static int[] S;
    static int size;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());

            if (size == 0) break; // 종료 조건

            S = new int[size];
            for (int i = 0; i < size; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, new int[6]); // 선택한 6개의 수 저장용 배열 전달
            sb.append('\n'); // 각 케이스마다 결과 구분
        }

        System.out.println(sb);
    }

    static void dfs(int startP, int count, int[] selected) {
        if (count == 6) {
            for (int num : selected) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = startP; i < size; i++) {
            selected[count] = S[i]; // 선택한 수를 저장
            dfs(i + 1, count + 1, selected); // 재귀 호출
        }
    }
}
