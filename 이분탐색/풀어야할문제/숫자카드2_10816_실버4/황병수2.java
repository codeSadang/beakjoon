package 이분탐색.풀어야할문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class 황병수2 {

    static int N,M;
    static int[] AList, BList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        AList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        BList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            BList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AList);

        StringBuilder sb = new StringBuilder();
        for (int curNum : BList) {
            int count = upperBound(curNum) - lowerBound(curNum);
            sb.append(count).append(" ");
        }
        System.out.println(String.valueOf(sb).trim());
    }

    // lowerBound: curNum의 첫 번째 등장 위치
    private static int lowerBound(int curNum) {
        int left = 0;
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (AList[mid] >= curNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // upperBound: curNum보다 큰 첫 번째 위치
    private static int upperBound(int curNum) {
        int left = 0;
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (AList[mid] > curNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
