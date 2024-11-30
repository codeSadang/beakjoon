package 분할정복.풀어야할문제.치킨TOPN_11582_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 치킨집 맛의 수치를 오름순으로 정렬
 *
 */
public class 황병수 {

    static int N,K;
    static int[] ListA;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ListA = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ListA[i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());

        tasteRank(ListA,N/2);
    }

    private static void tasteRank(int[] ListA, int memberCount) {
        // 정렬!!
        int size = memberCount/2;
        int index = 0;
        while (index < N) {
            for (int i = index; i < size; i++) {

            }
            index += size;
        }

        if (memberCount == 2) {
            // 각각 정렬!

            // 더함!
            return;
        }

        tasteRank(ListA, memberCount/2);
    }
}
