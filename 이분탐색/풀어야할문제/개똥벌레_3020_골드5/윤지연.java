package 이분탐색.풀어야할문제.개똥벌레_3020_골드5;
/*시간복잡도*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*문제풀이
* 이분탐색을 어디에 적용할 것이냐
* 종유석, 석순 배열의 구간값에 관한 탐색에 적용*/
public class 윤지연 {
    static int N, H;
    static int[] top, bottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottom = new int[N / 2];
        top = new int[N / 2];

        for (int i = 0; i < N / 2; i++) {
            bottom[i] = Integer.parseInt(br.readLine());
            top[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bottom);
        Arrays.sort(top);

        int min = N;
        int floorCount = 0;

        for (int h = 1; h <= H; h++) {
            int sum = getObstacles(h);

            if (sum < min) {
                min = sum;
                floorCount = 1;
            } else if (sum == min) {
                floorCount++;
            }
        }
        System.out.println(min + " " + floorCount);
    }

    // 파괴되는 장애물 개수 세기
    public static int getObstacles(int height) {
        int bottomCount = N / 2 - binarySearch(bottom, height);
        int topCount = N / 2 - binarySearch(top, H - height + 1);

        return bottomCount + topCount;
    }

    // 구간별 종유석, 석순 배열 이분 탐색하여 파괴되는 장애물 개수 찾기
    public static int binarySearch(int[] arr, int floor) {
        int left = 0, right = N / 2;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= floor) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
