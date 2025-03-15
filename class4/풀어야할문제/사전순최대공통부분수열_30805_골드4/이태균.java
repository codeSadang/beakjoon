package class4.풀어야할문제.사전순최대공통부분수열_30805_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int[] A;
    public static int M;
    public static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = solution(A, B);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        if (result.size() > 0) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static List<Integer> solution(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();

        int startA = 0;
        int startB = 0;

        while (true) {
            int max = -1;
            int idxA = -1;
            int idxB = -1;

            for (int i = startA; i < N; i++) {
                for (int j = startB; j < M; j++) {
                    if (A[i] == B[j] && A[i] > max) {
                        max = A[i];
                        idxA = i;
                        idxB= j;
                    }
                }
            }

            if (max == -1) {
                break;
            }

            result.add(max);
            startA = idxA + 1;
            startB = idxB + 1;
        }

        return result;
    }

}