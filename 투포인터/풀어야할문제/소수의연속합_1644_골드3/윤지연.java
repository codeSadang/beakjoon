package 투포인터.풀어야할문제.소수의연속합_1644_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    소수 판별 메서드
    소수 배열을 만들어 두고 사용할 것이냐
     */

    static int N;
    static int result = 0; // wk
    static boolean[] isPrime;
    static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        isPrime = new boolean[N + 1];

        makePrime();

        twoPointer();

        System.out.println(result);
    }

    public static void twoPointer() {
        int s = 0;
        int e = 0;
        int sum = 0;

        while (s < prime.size()) {
            if (sum < N) {
                sum += prime.get(e++);
            } else if (sum > N){
                sum -= prime.get(s++);
            } else {
                result++;
                sum -= prime.get(s++);
            }
        }
    }

    public static void makePrime() {
        if (N < 2) {
            return;
        }

        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= N; i++) {

            if (isPrime[i] == true) {
                continue;
            } else {
                prime.add(i);
            }

            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = true;
            }
        }
    }
}
