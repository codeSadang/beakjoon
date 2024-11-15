package 이분탐색.풀어야할문제.숫자카드2_10816_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int n, m;

    static int[] nCard, mCard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nCard = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < n; i++ ) {
            nCard[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        mCard = new int[m];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < m; i++ ) {
            mCard[i] = Integer.parseInt(st.nextToken());
        }

        // nCard 배열 정렬
        Arrays.sort(nCard);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            int target = mCard[i];
            int cnt = upperBound(target) - lowerBound(target);

            // target의 lowerBound와 upperBound를 구해서 둘의 차이를 구한다.
            sb.append(cnt).append(" ");
        }

        System.out.print(sb.toString().trim());
    }
    
    public static int lowerBound(int target) {
        // target이 시작하는 가장 왼쪽 인덱스를 찾는다.
        int lt = 0;
        int rt = n;

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            if (nCard[mid] >= target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }

    public static int upperBound(int target) {

        // target이 끝나는 가장 오른쪽 인덱스를 찾는다.

        int lt = 0;
        int rt = n;

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            if (nCard[mid] > target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}
