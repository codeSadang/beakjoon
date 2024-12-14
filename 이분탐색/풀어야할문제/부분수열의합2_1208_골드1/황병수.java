package 이분탐색.풀어야할문제.부분수열의합2_1208_골드1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * N개의 정수로 이루어진 수열
 * 크기가 양수인 부분수열 중에서 그 수열워 원소를 다 더한값이 S가 되는 경우
 *
 *
 */
public class 황병수 {
    static int N,S;
    static List<Integer> AList = new ArrayList<>();
    static List<Integer> BList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                AList.add(Integer.parseInt(st.nextToken()));
            } else {
                BList.add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Integer> dfsA = new ArrayList<>();
        List<Integer> dfsB = new ArrayList<>();

        // 조합 만들기
        for (int i = 0; i < AList.size(); i++) {
//            dfs(0, 0, i, AList);
        }

        for (int i = 0; i < BList.size(); i++) {
//            dfs(0, 0, i, BList);
        }


    }
}
