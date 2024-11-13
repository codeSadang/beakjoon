package 이분탐색.풀어야할문제.수찾기_1920_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 정수가 주어졌을 때 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성
 */
public class 황병수 {

    static int N,M;
    static int[] AList;
    static int[] BList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        AList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        N = Integer.parseInt(br.readLine());

        BList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            BList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AList);

        StringBuilder sb = new StringBuilder();

        // BList의 각 요소에 대해 이분 탐색
        for (int x : BList) {
            if (binarySearch(AList, x)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);


    }

    // 이분 탐색 메서드
    private static boolean binarySearch(int[] list, int target) {
        int start = 0;
        int end = list.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list[mid] == target) {
                return true;
            } else if (list[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
