package 깊이우선탐색.풀어야할문제.효율적인해킹_1325_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    static int ComputersCnt, QCnt;
    static List<List<Integer>> ComputerTree;
    static boolean[] visited;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        ComputersCnt = Integer.parseInt(st.nextToken());
        QCnt = Integer.parseInt(st.nextToken());
        ComputerTree = new ArrayList<>();
        visited = new boolean[ComputersCnt + 1];
        for (int i = 0; i <= ComputersCnt; i++) {
            ComputerTree.add(new ArrayList<>());
        }


        // 간선 입력
        for (int i = 0; i < QCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

//            ComputerTree.get(u).add(v);
            ComputerTree.get(v).add(u);
        }

        for (int i = 1; i <= ComputersCnt; i++) {
            visited = new boolean[ComputersCnt + 1];
            count = 0;
            dfs(i);
            map.put(i,count);

        }

        // 최대 value 값 찾기
        int maxValue = Collections.max(map.values());

        StringBuilder sb = new StringBuilder();
        // 최대 value 값을 가지는 key들을 리스트에 추가
        List<Integer> maxKeys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                sb.append(entry.getKey()).append(" ");
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // 마지막 공백 제거
        }

        System.out.println(sb);
    }

    static void dfs(int computerNum) {
        visited[computerNum] = true;
        count++;
        for (int neighbor : ComputerTree.get(computerNum)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
