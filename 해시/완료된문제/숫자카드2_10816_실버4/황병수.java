package 해시.완료된문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 숫자 카드는 정수 하나가 적혀져 있는 카드
 * 숫자카드 N개를 가지고 있고
 * 정수 M개가 주어졌을 떄 이 수가 적혀있는 숫자 카드를 상근이가 몇개 가지고 있는지?
 */
public class 황병수 {

    static int N,M;
    static int[] ListA;
    static HashMap<Integer, Integer> HashA = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ListA = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            HashA.put(num, HashA.getOrDefault(num, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num2 = Integer.parseInt(st.nextToken());
            sb.append(HashA.getOrDefault(num2, 0)).append(" ");
        }

        System.out.println(String.valueOf(sb).trim());
    }

}
