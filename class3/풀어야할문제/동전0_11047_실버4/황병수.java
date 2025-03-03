package class3.풀어야할문제.동전0_11047_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 준규가 가지고 있는 동전은 총 N 종류
 * 적절하게 사용하며 그 합이 K로 만들려고 한다.
 * 필요한 동전 개수의 최소 값
 */
public class 황병수 {

    static int[] valueMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        valueMap = new int[N];
        int restMoney = K;
        int count = 0;

        for (int i = 0; i < N; i++) {
            valueMap[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >= 0; i--) {
            if (valueMap[i] <= restMoney) {
                count += restMoney / valueMap[i];
                restMoney %= valueMap[i];
            }
        }

        System.out.println(count);
    }
}
