package 유니온파인드.풀어야할문제.집합의표현_1717_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 유니온 집합 = 그래프 알고리즘 = 두 노드가 같은 집합에 속하는지 판별하는 알고리즘
 * 합집합 알고리즘 = 서로소 집합 = Disjoint-set
 *
 * 랭크,
 * 크루스칼 알고리즘
 * 프림 알고리즘
 */
public class 황병수 {
    static int N,M;
    static int[] ListA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken());

        ListA = new int[N];
        for (int i = 0; i < N; i++) {
            ListA[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int isUnionOrUnion = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isUnionOrUnion == 0) {
                Union(a,b);
                System.out.println(Arrays.toString(ListA));
            } else {
                boolean union = isUnion(a, b);
                if (union) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
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
