package 유니온파인드.풀어야할문제.중량제한_1939_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 중량제한 문제를 해결하기 위한 유니온 파인드 구현.
 * 특정 중량 제한으로 두 섬이 연결 가능한지 확인.
 */
public class 황병수 {

    static int N, M; // 섬의 수와 다리의 수
    static int[] parent; // 유니온 파인드 부모 배열
    static List<Edge> edges = new ArrayList<>(); // 다리 정보 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int islandA = Integer.parseInt(st.nextToken());
            int islandB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(islandA, islandB, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 간선(다리)을 중량 제한 기준으로 내림차순 정렬
        edges.sort((e1, e2) -> e2.weight - e1.weight);

        // 가장 큰 중량 제한부터 확인하며 두 공장이 연결되는지 검사
        for (Edge edge : edges) {
            Union(edge.from, edge.to);
            if (isUnion(start, end)) {
                System.out.println(edge.weight);
                return;
            }
        }
    }

    // Find 연산: 루트 노드를 찾고 경로 압축
    static int Find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = Find(parent[x]);
    }

    // Union 연산: 두 노드를 같은 그룹으로 합치기
    static void Union(int x, int y) {
        x = Find(x);
        y = Find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    // 같은 그룹인지 확인
    static boolean isUnion(int x, int y) {
        return Find(x) == Find(y);
    }

    // 간선(다리) 정보를 저장하기 위한 클래스
    static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
