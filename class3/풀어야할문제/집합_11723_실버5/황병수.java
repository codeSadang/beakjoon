package class3.풀어야할문제.집합_11723_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램
 * add x = x 추가되어있으면 무시
 * remove x = x 없으면 무시
 * check x = x 가 있으면 1, 없으면 0. 출력
 * toggle x = x 가 있으면 제거, 없으면 추가
 * all = S 를 {1,2,3,...20} 으로 바꾼다.
 * empty = S를 공집합으로 바꾼다.
 */
public class 황병수 {

    static int N;
    static HashSet<Integer> set = new HashSet<>(); // 빠른 탐색을 위한 HashSet
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int num = 0;

            if (!command.equals("all") && !command.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    sb.append(set.contains(num) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) set.add(j);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}
