package 다이나믹프로그래밍.풀어야할문제.설탕배달_2839_실버4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설탕을 N킬로그램 배달해야하는데
 * 봉지는 3kg 5kg 봉지가 있다.
 *
 * 최대한 적은 봉지를 들고 가려고 한다.
 * 18킬로그램 설탕을 배달해야 할 때
 *
 * 배달할 수 잇는 방법은?
 * 정확하게 만들 수 없다면 -1 출력
 */
public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n >= 0) {
            if (n % 5 == 0) {
                cnt += n / 5;

                System.out.println(cnt);
                return;
            }
            n -= 3;
            cnt++;
        }

        System.out.println(-1);
    }
}
