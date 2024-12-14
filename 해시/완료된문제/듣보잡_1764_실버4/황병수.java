package 해시.완료된문제.듣보잡_1764_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 듣도 못한 사람의 명단과 보도못한 사람의 명단이 주어질 때
 * 듣도 보도 못한 사람의 명단을 구하시오
 */
public class 황병수 {
    static int N,M;
    static HashSet<String> noHear = new HashSet<>();
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            noHear.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String selectName = br.readLine();
            if (noHear.contains(selectName)) {
                result.add(selectName);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String bothName : result) {
            sb.append(bothName).append("\n");
        }

        System.out.println(sb);
    }
}
