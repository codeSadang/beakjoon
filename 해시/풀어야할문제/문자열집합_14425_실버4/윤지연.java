package 해시.풀어야할문제.문자열집합_14425_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 윤지연 {

    static int N, M;
    static Set<String> stringSet = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            stringSet.add(br.readLine());
        }

        int count = 0;
        for (int j = 0; j < M; j++) {
            String inputValue = br.readLine();
            if (stringSet.contains(inputValue)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
