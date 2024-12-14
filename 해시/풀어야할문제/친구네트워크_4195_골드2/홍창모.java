package 해시.풀어야할문제.친구네트워크_4195_골드2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
* Union find 알고리즘을 사용해야한다.
* Union: 서로 다른 두 개의 집합을 하나의 집합으로 병합하는 연산을 말한다. 이 자료구조에서는 상호 배타적 집합만을 다루므로 Union 연산은 합집한 연산과 같다.
* Find: 하나의 원소가 어떤 집합에 속해있는지를 판단한다.
* */
public class 홍창모 {

    static int TEST_CASE;
    static int[] PARENT;
    static int[] NETWORK_SIZE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수 입력
        TEST_CASE = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < TEST_CASE; testCase++) {
            // 친구 관계의 수 입력
            int f = Integer.parseInt(br.readLine());

            // 이름-인덱스 매핑을 위한 해시맵
            Map<String, Integer> nameToIndex = new HashMap<>();

            // 최대 가능한 친구 수 * 2로 배열 초기화
            PARENT = new int[2 * f + 1];
            NETWORK_SIZE = new int[2 * f + 1];

            // 인덱스 초기화
            for (int i = 0; i < 2 * f + 1; i++) {
                PARENT[i] = i;
                NETWORK_SIZE[i] = 1;
            }

            // 다음에 부여할 인덱스
            int nextIndex = 0;

            // 각 친구 관계 처리
            for (int i = 0; i < f; i++) {
                // 두 친구 이름 입력
                String[] friends = br.readLine().split(" ");
                String a = friends[0];
                String b = friends[1];

                // 첫 번째 친구 이름에 대한 인덱스 할당
                if (!nameToIndex.containsKey(a)) {
                    nameToIndex.put(a, nextIndex++);
                }

                // 두 번째 친구 이름에 대한 인덱스 할당
                if (!nameToIndex.containsKey(b)) {
                    nameToIndex.put(b, nextIndex++);
                }

                // 두 친구의 네트워크 크기 출력
                bw.write(union(nameToIndex.get(a), nameToIndex.get(b)) + "\n");
            }
        }

        // 버퍼 비우기
        bw.flush();
        bw.close();
        br.close();
    }

    // find 연산 (경로 압축 최적화)
    static int find(int x) {
        if (PARENT[x] != x) {
            // 같은 집합으로 처리하기 위해 재귀적으로 호출함
            PARENT[x] = find(PARENT[x]);
        }
        return PARENT[x];
    }

    // union 연산 (네트워크 크기 추적)
    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        // 다른 네트워크일 경우에만 합집합 연산 수행
        if (x != y) {
            // 더 작은 인덱스를 가진 집합을 부모로 설정
            if (x < y) {
                PARENT[y] = x;
                NETWORK_SIZE[x] += NETWORK_SIZE[y];
                return NETWORK_SIZE[x];
            } else {
                PARENT[x] = y;
                NETWORK_SIZE[y] += NETWORK_SIZE[x];
                return NETWORK_SIZE[y];
            }
        }

        // 이미 같은 네트워크일 경우 현재 네트워크 크기 반환
        return NETWORK_SIZE[x];
    }
}
