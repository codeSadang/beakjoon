package 투포인터.완료된문제.먹을것인가먹힐것인가_7795_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    1. 테스트케이스 개수
    2. A의 수 B의 수
    3. A의 크기
    4. B의 크기
    5. 2-4 반복
     */

    static int T;
    static int N;
    static int M;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);
            int count = twoPointer(A, B);
            System.out.println(count);
        }

    }

    public static int twoPointer(int[] A, int[] B) {
        int a = 0, b = 0, count = 0;

        while (a < N) {
            while (b < M && A[a] > B[b]) {
                b++;
            }
            count += b;
            a++;
        }
        return count;
    }
}
