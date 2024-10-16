package 백트래킹.풀어야할문제.감소하는수_1038_골드5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 음이 아닌 정수 X의 자릿수가 큰 수부터 작은 자릿수까지 감소한다면 그 수를 감소하는 수 라고 한다.
 * N번째 감소하는 수를 출력하는 프로그램을 만드시오
 *
 * 0 은 0번째 감소하는 수
 * 1은 1번째 감소하는수다.
 *
 * 만약 N번째 감소하는 수가 없다면, -1 출력
 */
public class 황병수 {

    static long result = -1;
    static int count = 0;  // 감소하는 수의 인덱스를 추적하기 위한 변수
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 한 자리수부터 시작해서 최대 10자리 감소하는 수까지 확인
        for (int i = 1; i <= 10; i++) {
            if (result != -1) break;  // 원하는 감소 수를 찾았으면 종료
            findDecreasingNumber(0, i, 0);
        }

        System.out.println(result);
    }

    private static void findDecreasingNumber(long current, int length, int lastDigit) {
        if (length == 0) {
            if (count == N) {
                result = current;
            }
            count++;
            return;
        }

        for (int digit = lastDigit; digit < 10; digit++) {
            findDecreasingNumber(current * 10 + digit, length - 1, digit + 1);
        }
    }
}
