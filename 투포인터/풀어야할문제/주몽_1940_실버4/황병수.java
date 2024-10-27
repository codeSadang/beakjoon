package 투포인터.풀어야할문제.주몽_1940_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 철기군 양성
 * 갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다.
 * 갑옷은 두개의 재료로 만드는데 두 재료의 고유번호르 합쳐서 M이 되면 갑옷이 만들어진다.

 * 야철대장은 자신이 가지고 있는 재료를 가지고 갑옷을 몇개 만들 수 있을까!?
 * N개의 재료과 M이 주어졌다.

 * 첫째줄에는 재료의 갯수 N
 * 두번째 줄에는 갑옷을 만드는데 필료한 수 M
 * 셋째줄에는 N개의 재료들이 가진 고유한 번호들
 */
public class 황병수 {
    static int N,M;
    static int[] NList;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        NList = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(NList);

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = NList[left] + NList[right];
            if (sum == M) {
                result++;
                left++;
                right--;
            }

            else if (sum > M) right--;
            else left++;
        }

        System.out.println(result);
    }
}
