package 해시.풀어야할문제.듣보잡_1764_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N, M;
    static HashSet<String> people = new HashSet<>();
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람 명단 작성
        for (int i = 0; i < N; i++) {
            people.add(br.readLine());
        }

        // 듣도 + 보도 못한 사람인가 확인하고 answer 리스트에 작성
        for (int j = 0; j < M; j++) {
            String person = br.readLine();
            if (people.contains(person)) {
                answer.add(person);
            }
        }

        System.out.println(answer.size()); // 듣도 보도 못한 사람 수
        answer.stream().sorted().forEach(System.out::println);
    }
}
