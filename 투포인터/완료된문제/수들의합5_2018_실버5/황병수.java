package 투포인터.완료된문제.수들의합5_2018_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 자연수 N
 * 합이 N이 되는 연속된 자연수의 합을 찾아라
 */
public class 황병수 {

    static int Target;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Target = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 0;

        while (left < Target) {
            while (sum < Target) {
                sum += right;
                right++;
            }

            if (sum == Target) {
                result++;
            }

            sum -= left;
            left++;
        }

        // 자기 자신 추가
        System.out.println(result + 1);
    }
}
