package class3.다시풀어볼문제.IOIOI_5525_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine(); // 입력 문자열

        int count = 0; // P(N) 패턴의 개수
        int patternCount = 0; // 연속된 "OI"의 개수

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                patternCount++; // "OI"가 연속되면 증가

                if (patternCount >= N) {
                    count++; // N개 이상이면 P(N) 패턴 개수 증가
                }
                i++; // "OI"를 찾았으므로 다음 'I'에서 다시 검사
            } else {
                patternCount = 0; // 패턴이 끊기면 초기화
            }
        }

        System.out.println(count);


    }
}
