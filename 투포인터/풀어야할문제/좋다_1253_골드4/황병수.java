package 투포인터.풀어야할문제.좋다_1253_골드4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N개의 수 중에서 어떤 수가 다른 수 두개의 합으로 나타낼 수 있다면 그 수를 좋다고 한다.
 * N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇개인지 출력하라.
 * 수의 위치가 다르면 값이 같아도 다른 수이다.
 */
public class 황병수 {
    static int N;
    static int[] AList;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        AList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AList);

        for (int i = 0; i < N; i++) {
            int target = AList[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }

                if (right == i) {
                    right--;
                    continue;
                }

                int sum = AList[left] + AList[right];

                if (sum == target) {
                    count++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}
