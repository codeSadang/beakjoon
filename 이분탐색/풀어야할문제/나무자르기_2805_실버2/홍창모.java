package 이분탐색.풀어야할문제.나무자르기_2805_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, M;

    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int answer = binarySearch();
    }

    public static int binarySearch() {
        int answer = 0;

        int lt = 0, rt = N-1;

        // 최대 높이 나무의 반값
        int midH = tree[N-1] / 2;
        int maxH = tree[N-1];


        while( lt <= rt && midH < maxH ) {
            int cut = 0;
            int mid = lt + (rt - lt) /2;

            // mid 값보다 작은 높이는 탐색이 필요없음.
            if( tree[mid] - midH < 0 ) {
                lt = mid + 1;
            } else if( tree[mid] - midH > 0 ) {
                for( int i = mid; i < rt; i++ ) {
                    cut += tree[i] - midH;
                }
                midH++;
            }


            if( cut >= M ) answer = midH;

        }

        return answer;
    }
}
