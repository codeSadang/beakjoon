package 이분탐색.풀어야할문제.개똥벌레_3020_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 황병수 {
    static int N, H;
    static List<Integer> downList = new ArrayList<>();
    static List<Integer> upList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 입력 처리
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                downList.add(height);
            } else {
                upList.add(height);
            }
        }

        // 정렬
        Collections.sort(downList);
        Collections.sort(upList);

        // 최소값과 해당 경우의 수 초기화
        int minObstacles = Integer.MAX_VALUE;
        int count = 0;

        // 높이 1부터 H까지 확인
        for (int h = 1; h <= H; h++) {
            int obstacles = countObstacles(h);

            if (obstacles < minObstacles) {
                minObstacles = obstacles;
                count = 1;
            } else if (obstacles == minObstacles) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(minObstacles + " " + count);
    }

    private static int countObstacles(int h) {
        // 석순에서 h 이상에 해당하는 장애물 개수
        int down = downList.size() - binarySearch(downList, h - 1);
        // 종유석에서 H - h 이상에 해당하는 장애물 개수
        int up = upList.size() - binarySearch(upList, H - h);

        return down + up;
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left; // target 이상의 첫 번째 위치 반환
    }
}
