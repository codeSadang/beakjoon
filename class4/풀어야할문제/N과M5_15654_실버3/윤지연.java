package class4.풀어야할문제.N과M5_15654_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {

    /*
    * 중복x
    * 수를 선택할 때마다
    *   이미 선택한 수인지 확인
    *   선택한 수를 저장
    *   M개를 모두 선택했는지 확인*/
    static int[] arr;
    static StringBuilder answer = new StringBuilder();
    static int[] result;
    static boolean[] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        permutation(0);
        System.out.println(answer.toString());
    }

    static void permutation(int depth) {
        // 종료 조건: m개를 모두 선택하면 출력
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                answer.append(result[i]).append(" ");
            }
            answer.append("\n");
            return;
        }

        // 수 선택
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 선택하지 않은 수일 때
                visited[i] = true; // 선택 표시
                result[depth] = arr[i]; // 결과배열에 선택한 수 저장
                permutation(depth + 1); // 다음 수 선택
                visited[i] = false;
            }
        }
    }
}
