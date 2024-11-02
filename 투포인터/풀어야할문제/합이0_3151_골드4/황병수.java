package 투포인터.풀어야할문제.합이0_3151_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 3명으로 구성된 팀 참가
 * 코딩실력이 좋으면 팀워크가 떨어지고
 * 팀워크가 좋을수록 코딩 실력이 떨어진다.
 * 그리고 출전하고자 하는 대화는 둘 다 중요함
 *
 * 학원의 학생들을 3명씩 짝지어서 코딩 실력의 합이 0이 되는 팀을 만들자!
 * 3인조를 만들 수 있는 경우의 수를 구하라! (최대한 많이 만들 수 있는 수로)
 */
public class 황병수 {

    static int N;
    static int[] AList;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        AList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AList);

        int left = 0;
        int middle = 0;
        int right = 0;

        // 제일 오른쪽수가 끝에 다다를 때까지

        while (true) {

            int sum = AList[left] + AList[middle] + AList[right];

            while (middle < right && right < N && sum == 0) {
                right = right + 1;

            }

            if (right > N) {
                middle = left + 1;
                right = middle + 1;

            } else {

            }



        }
    }
}
