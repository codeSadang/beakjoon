package 유니온파인드.풀어야할문제.여행가자_1976_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 동혁이는 친구들과 함께 여행을 가려고 한다.
 * 도시가 N개가 있고
 * 임의의 두 도시 사이의 길이 잇을 수도 있고 없을수 도 있다
 * 이 여행 경로가 가능한 것인지 알아보자.
 *
 * 물론 중간에 다른 도시를 경유해서 여행을 할 수 있다.
 *
 * 예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A 의 길이 있고
 *
 * 여행 계획이 E,C,B,C,D 라면
 * E-A-B-C-B-C-B-D
 */
public class 황병수 {
    static int N,M;
    static int[] ListA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ListA = new int[N];
        for (int i = 0; i < N; i++) {
            ListA[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int checkOne = Integer.parseInt(st.nextToken());
                if (checkOne == 1) {
                    Union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int before = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            boolean union = isUnion(before, next);
            before = next;
            if (!union) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static int Find(int x) {
        if (x == ListA[x]) return x;
        return ListA[x] = Find(ListA[x]);
    }

    static void Union(int x, int y) {
        x = Find(x);
        y = Find(y);

        if (x == y) return;
        if (x < y) {
            ListA[y] = x;
        } else {
            ListA[x] = y;
        }
    }

    static boolean isUnion(int x, int y) {
        x = Find(x);
        y = Find(y);
        return (x==y);
    }
}
