package 이분탐색.풀어야할문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int M;
    static int[] cards;
    static int[] targets;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            upgradeBinarySearch(targets[i]);
        }
        System.out.println(result.toString());
    }

    private static void binarySearch(int target) {
        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (target == cards[mid]) {
//                countTarget(mid, target);
                upgradeCountTarget(mid, target);
                return;
            } else if (target < cards[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        result.append(0).append(" ");
    }
    
    private static void countTarget(int mid, int target) {
        int l = mid - 1;
        int r = mid + 1;
        int count = 1;

        if (l > -1 && r < N) {
            if (target == cards[l] || target == cards[r]) {
                while (l >= 0 && r < N) {
                    if (target == cards[l]) {
                        count++;
                        l--;
                    } else if (target == cards[r]) {
                        count++;
                        r++;
                    } else {
                        result.append(count).append(" ");
                        break;
                    }
                }
            }
        }
        result.append(count).append(" ");
    }

    private static void upgradeCountTarget(int mid, int target) {
        int count = 1;

        // 왼쪽으로 탐색
        int left = mid - 1;
        while (left >= 0 && cards[left] == target) {
            count++;
            left--;
        }

        // 오른쪽으로 탐색
        int right = mid + 1;
        while (right < N && cards[right] == target) {
            count++;
            right++;
        }

        result.append(count).append(" ");
    }

    /*count 대신 index 활용을 고려해보자*/
    private static void upgradeBinarySearch(int target) {
        // Lower bound (첫 번째 위치) 찾기
        int low = 0;
        int high = N;
        while (low < high) {
            int mid = (low + high) / 2;
            if (cards[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int first = low;

        // Upper bound (마지막 위치 + 1) 찾기
        low = 0;
        high = N;
        while (low < high) {
            int mid = (low + high) / 2;
            if (cards[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int last = low;

        result.append(last - first).append(" ");
    }
}
