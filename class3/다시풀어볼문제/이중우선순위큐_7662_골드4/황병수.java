package class3.다시풀어볼문제.이중우선순위큐_7662_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 황병수 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int size = Integer.parseInt(br.readLine());
            getResult(size, br);
        }

        System.out.println(sb);
    }

    private static void getResult(int size, BufferedReader br) throws IOException {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 정렬된 상태 유지하는 이중 우선순위 큐 역할

        for (int j = 0; j < size; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String act = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (act.equals("I")) {
                // 입력: map에 값을 저장하고 개수를 관리
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            if (act.equals("D")) {
                if (map.isEmpty()) continue; // 큐가 비어있으면 무시

                if (num == 1) {
                    // 최댓값 삭제
                    int maxKey = map.lastKey();
                    if (map.get(maxKey) == 1) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                } else {
                    // 최솟값 삭제
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
        }

        if (map.isEmpty()) {
            sb.append("EMPTY").append('\n');
        } else {
            sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
        }
    }
}