package 유니온파인드.풀어야할문제.거짓말_1043_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 윤지연 {
    // 파티 참석자가 '진실을 아는 사람'의 부분집합인지 확인하기

    static int N; // 사람의 수
    static int M; // 파티의 수
    static int truthCount; // 진실을 아는 사람의 수
    static int[] parent;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력처리
        // 1-1. 기본 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 1-2. 진실을 아는 사람들 입력
        st = new StringTokenizer(br.readLine());
        truthCount = Integer.parseInt(st.nextToken());

        // 1-3. 진실을 아는 사람의 수가 0이면 모든 파티에서 거짓말 가능함
        if (truthCount == 0) {
            System.out.println(M);
            return;
        }

        // 1-4. 진실을 아는 사람들을 하나의 그룹으로 묶기
        int firstTruthPerson = Integer.parseInt(st.nextToken());
        for (int i = 1; i < truthCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            union(firstTruthPerson, person);
        }

        // 2. 파티 정보 저장
        // 2-1. 파티 정보 저장할 배열 생성
        ArrayList<Integer>[] parties = new ArrayList[M];

        // 2-2. 각 파티 정보 입력받고 처리
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>(); // i번째 파티의 참석자 리스트 초기화
            st = new StringTokenizer(br.readLine());
            
            int partyCount = Integer.parseInt(st.nextToken()); // 파티 참석자 수

            if (partyCount > 0) {
                int firstPerson = Integer.parseInt(st.nextToken()); // 첫 번째 참석자
                parties[i].add(firstPerson);

                // 같은 파티 사람들 모두 union
                for (int j = 1; j < partyCount; j++) {
                    int person = Integer.parseInt(st.nextToken());
                    parties[i].add(person);
                    union(firstPerson, person);
                }
            }
        }

        // 3. 파티에서 거짓말 할 수 있는지 확인
        for (ArrayList<Integer> party : parties) {
            if (!party.isEmpty()) {
                if (find(party.get(0)) != find(firstTruthPerson)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}

/*
*
4 3
0
2 1 2
1 3
3 2 3 4
*/