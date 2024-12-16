package 유니온파인드.풀어야할문제.친구네트워크_4195_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 황병수 {

    static int[] parents;
    static int[] sizes; // 각 집합의 크기
    static HashMap<String, Integer> nameMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 출력 관리용

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            parents = new int[F * 2 + 1];
            sizes = new int[F * 2 + 1];
            nameMap = new HashMap<>();

            // 초기화
            for (int i = 0; i <= F * 2; i++) {
                parents[i] = i; // 자기 자신이 부모
                sizes[i] = 1;   // 초기 크기는 1
            }

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                int num1 = getNumber(name1);
                int num2 = getNumber(name2);

                // Union 연산으로 연결
                sb.append(Union(num1, num2)).append("\n");
            }
        }
        System.out.print(sb); // 결과를 한 번에 출력
    }

    private static int getNumber(String name) {
        if (!nameMap.containsKey(name)) {
            nameMap.put(name, nameMap.size() + 1);
        }
        return nameMap.get(name);
    }



    private static int Union(int x, int y) {
        x = Find(x);
        y = Find(y);

        if (x != y) {
            if (sizes[x] < sizes[y]) {
                parents[x] = y;
                sizes[y] += sizes[x];
                return sizes[y];
            } else {
                parents[y] = x;
                sizes[x] += sizes[y];
                return sizes[x];
            }
        }
        return sizes[x]; // 이미 같은 집합이라면 크기 반환
    }

    private static int Find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = Find(parents[x]);
    }
}
