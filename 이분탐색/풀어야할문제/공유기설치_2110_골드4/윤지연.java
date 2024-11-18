package 이분탐색.풀어야할문제.공유기설치_2110_골드4;
/**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
가장 중요한 점은 "우리가 이진 탐색으로 찾아야 하는 것"이 무엇인지 파악하는 것입니다.

이 문제에서는 "공유기 간의 최소 거리"를 이진 탐색으로 찾아야 합니다.

어떤 거리를 기준으로 공유기를 설치했을 때:

공유기를 C개 이상 설치할 수 있다면? -> 거리를 늘려볼 수 있습니다
C개 미만으로만 설치할 수 있다면? -> 거리를 줄여야 합니다

탐색 범위:

최소 거리: 1
최대 거리: 가장 먼 두 집 사이의 거리
*/

public class 윤지연 {
    static int N;
    static int C;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int s = 1; // 최소 거리
        int e = houses[N - 1] -houses[0]; // 최대 거리
        int result = 0; // 결과값

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (canInstall(mid)) {
                result = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return result;
    }
    
    private static boolean canInstall(int distance) {
        int count = 1;
        int lastPosition = houses[0];
        
        for (int i = 1; i < N; i++) {
            if (houses[i] - lastPosition >= distance) {
                count++;
                lastPosition = houses[i];
            }
        }
        return count >= C; // 설치한 공유기 개수가 C개 이상이면 true 반환
    }
}
