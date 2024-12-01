package 해시.풀어야할문제.숫자카드_10815_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 숫자 카드는 정수 하나가 적혀져 있고
 * 상근이는 숫자카드 N개를 가지고 있다.
 * 정수 M개가 주어졌을 떄 상근이가 가지고 있는지 아닌지 구하는 프로그램
 */
public class 황병수 {
    static int N,M;
    static HashSet<Integer> HashA = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            HashA.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean contains = HashA.contains(Integer.parseInt(st.nextToken()));
            if (contains) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(String.valueOf(sb).trim());
    }
}
