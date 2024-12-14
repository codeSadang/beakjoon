package 해시.완료된문제.문자열집합_14425_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 총 N개의 문자열로 이루어진 집합 S가 주어진다.
 * 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는것은 몇개인가
 */
public class 황병수 {
    static int N,M;
    static HashSet<String> HashA = new HashSet<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            HashA.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (HashA.contains(br.readLine())) {
                result++;
            }
        }

        System.out.println(result);
    }
}
