package class3.다시풀어볼문제.카잉달력_6064_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    static StringBuilder sb = new StringBuilder();
    static int M,N,x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int lcm = lcm(M,N);
            boolean found = false;

            // x를 기준으로 k 값을 증가시키며 탐색
            for (int k = x; k <= lcm; k += M) {
                if ((k - 1) % N + 1 == y) {
                    sb.append(k).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append(-1).append("\n");
            }

        }

        System.out.println(sb);
    }

    // 최대공약수(GCD) 계산 (유클리드 호제법)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 계산
    private static int lcm(int a, int b) {
        return (a * b / gcd(a,b));
    }
}
