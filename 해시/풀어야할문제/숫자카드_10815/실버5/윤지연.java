package 해시.풀어야할문제.숫자카드_10815.실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 윤지연 {

    /**/

    static int N, M;
    static HashSet<Integer> numbers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder answer = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            int cardNum = Integer.parseInt(st.nextToken());
            if (numbers.contains(cardNum)) {
                answer.append("1 ");
            } else {
                answer.append("0 ");
            }
        }
        System.out.println(answer.toString().trim());
    }
}
