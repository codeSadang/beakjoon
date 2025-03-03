package class3.풀어야할문제.좌표압축_18870_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] original = new int[N];  // 원래 배열
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 배열을 정렬하기 위해 복사 후 정렬
        int[] sorted = original.clone();
        Arrays.sort(sorted);

        // 2. 압축된 좌표를 매핑할 HashMap 생성
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int num : sorted) {
            if (!map.containsKey(num)) {  // 중복 방지
                map.put(num, rank++);
            }
        }

        // 3. 원래 순서대로 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : original) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
