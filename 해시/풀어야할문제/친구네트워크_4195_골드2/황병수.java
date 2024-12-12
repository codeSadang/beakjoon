package 해시.풀어야할문제.친구네트워크_4195_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 민혁이는 소셜 네트웍에서 친구를 만드는걸 좋아한다.
 * 친구 관계가 생긴 순서대로 주어졌을 떄
 * 두 사람의 친구 네트워크에 몇명이 있는지 구하는 프로그램
 *
 * 친구 네트워크랑 친구 관계로만 이동할 수 있는 사이
 */
public class 황병수 {

    static HashMap<String, Integer> friendMap; // 친구 이름 -> 번호 매핑
    static int[] parent;  // 부모 노드
    static int[] size;    // 각 네트워크의 크기
    static int index;     // 현재 친구 수 (고유 번호)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 후위 감소 연산자 : 반복할 떄마다 1씩 감소해서 총 N번 반복
        // 결국 0이되면 반복 종료
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine()); // 친구 관계 개수
            parent = new int[F * 2]; // 최대 친구 수만큼 부모 배열
            size = new int[F * 2]; // 각 그룹의 크기 배열
            Arrays.fill(parent, -1); // 초기값은 -1 (자기 자신이 부모)

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friendA = st.nextToken();
                String friendB = st.nextToken();

                int idA = getId(friendA);
                int idB = getId(friendB);

                // 두 친구를 하나의 네트워크로 합침
                System.out.println(union(idA, idB));
            }
        }
    }

    // 친구의 고유 번호를 가져오는 함수
    private static int getId(String friend) {
        if (!friendMap.containsKey(friend)) {
            friendMap.put(friend, index++);
        }
        return friendMap.get(friend);
    }

    // 두 친구를 합치는 함수
    private static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 서로 다른 집합이라면 합침
        if (rootA != rootB) {
            parent[rootB] = rootA; // rootB의 부모를 rootA로 설정
            size[rootA] += size[rootB]; // rootA의 크기에 rootB의 크기를 더함
        }

        return size[rootA]; // rootA가 속한 네트워크의 크기 반환
    }

    // 친구의 루트(최상위 부모)를 찾는 함수
    private static int find(int node) {
        if (parent[node] == -1) {
            parent[node] = node; // 자기 자신이 부모일 경우
        }
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // 부모를 재귀적으로 찾음
        }
        return parent[node];
    }
}
