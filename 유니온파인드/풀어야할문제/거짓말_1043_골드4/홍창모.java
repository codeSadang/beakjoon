package 유니온파인드.풀어야할문제.거짓말_1043_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 파티의 수

        // 부모 배열 초기화
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 진실을 아는 사람들 정보 입력
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        HashSet<Integer> truthPeople = new HashSet<>();

        for (int i = 0; i < truthCount; i++) {
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 정보 저장
        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            ArrayList<Integer> party = new ArrayList<>();

            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }

            // 같은 파티의 사람들을 하나의 집합으로 묶기
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }

            parties.add(party);
        }

        // 진실을 아는 사람들의 집합 확인
        HashSet<Integer> truthSet = new HashSet<>();
        for (int person : truthPeople) {
            truthSet.add(find(person));
        }

        // 거짓말을 할 수 있는 파티 개수 계산
        int answer = 0;
        for (ArrayList<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthSet.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축 최적화
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}