package 이분탐색.풀어야할문제.공유기설치_2110_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 황병수 {

    static int N, C;
    static long[] AList, BList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        AList = new long[N];
        for (int i = 0; i < N; i++) {
            AList[i] = Long.parseLong(br.readLine());
        }

        // 집 좌표 정렬
        Arrays.sort(AList);

        // 두 집 사이의 거리를 계산하여 BList에 저장
        BList = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            BList[i] = AList[i + 1] - AList[i] + 1; // +1이 필요한 경우 포함
        }

        Arrays.sort(BList);

        long left = 1; // 최소 거리
        long right = AList[N - 1] - AList[0]; // 최대 거리
        long mid = 0;
        long result = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            // 해당 거리로 공유기를 설치 가능한 최대 수 계산
            int maxLength = calcHouse(mid);

            if (maxLength >= C) {
                result = mid; // 조건을 만족할 경우 결과 갱신
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static int calcHouse(long distance) {
        int count = 1; // 첫 번째 집에 공유기를 설치
        long lastInstalled = AList[0]; // 마지막으로 설치한 집의 위치

        for (int i = 1; i < N; i++) {
            if (AList[i] - lastInstalled >= distance) {
                count ++;
                lastInstalled = AList[i]; // 공유기 설치
            }
        }
        return count;
    }
}
