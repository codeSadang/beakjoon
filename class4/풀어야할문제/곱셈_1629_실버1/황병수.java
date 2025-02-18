package class4.풀어야할문제.곱셈_1629_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    // 분할 정복을 활용한 거듭제곱 연산
    private static long pow(long base, long exp, long mod) {
        if (exp == 0) return 1; // A^0 = 1
        if (exp == 1) return base % mod; // A^1 = A % C

        long half = pow(base, exp / 2, mod);
        half = (half * half) % mod; // A^(B/2) * A^(B/2) % C

        if (exp % 2 == 0) return half; // B가 짝수인 경우
        else return (half * base) % mod; // B가 홀수인 경우 (추가적으로 A를 한 번 더 곱함)
    }
}
