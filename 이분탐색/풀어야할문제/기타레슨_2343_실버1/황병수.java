package 이분탐색.풀어야할문제.기타레슨_2343_실버1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.StringTokenizer;

/**
 * 기타강의 동영상을 블루레이로 만등러 판매
 * 총 N개의 강의가 있는데, 강의 순서가 바뀌면 안된다.
 *
 * i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j사이의 강의를 모두 같은블루레이에 녹화
 * 블루레이의 개수를 가급적 줄이려고 함.
 * M개의 블루레이에 모든 동영상을 녹화하고, 블루레이의 크기를 최소한으로 하려고 한다.
 * 단, M개의 블루레이는 모두 같은 크기여야함!
 *
 * 각 강의의 길이가 분단위로 주어진다.
 * 이때, 가능한 블루레이의 크기 중 최소를 구하여라
 */
public class 황병수 {

    static int N,M,T;
    static int[] AList;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        AList = new int[N];
        T = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
            T += AList[i];
        }

        Arrays.sort(AList);

        int left = AList[N-1];
        int right = T;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int count = calcVideo(mid);
            if (count <= M) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static int calcVideo(long maxVideoLength) {
        long currentSize = 0;
        int count = 1; // 첫 번째 블루레이부터 시작

        for (int i = 0; i < N; i++) {
            if (currentSize + AList[i] > maxVideoLength) {
                // 현재 블루레이에 넣을 수 없으면 새로운 블루레이 사용
                count++;
                currentSize = AList[i];
            } else {
                // 현재 블루레이에 강의 추가
                currentSize += AList[i];
            }
        }
        return count;
    }
}
