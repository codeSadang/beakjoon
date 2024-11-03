package 투포인터.완료된문제.배열합치기_11728_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;

    public static Integer[] ARR_A;
    public static Integer[] ARR_B;

    public static StringBuilder SB = new StringBuilder();
//    public static List<Long> ARR_RESULT = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR_A = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR_A[i] = Integer.parseInt(st.nextToken());
        }

        ARR_B = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ARR_B[i] = Integer.parseInt(st.nextToken());
        }

        two_pointer();

        System.out.println(SB);
    }

    private static void two_pointer() {
        int left = 0;
        int right = 0;

        while (left < N && right < M) {
            if (ARR_A[left] <= ARR_B[right]) {
                SB.append(ARR_A[left++]).append(" ");
            } else {
                SB.append(ARR_B[right++]).append(" ");
            }
        }

        while (left < N) {
            SB.append(ARR_A[left++]).append(" ");
        }

        while (right < M) {
            SB.append(ARR_B[right++]).append(" ");
        }
    }

//    private static void array_sorting() {
//        ARR_RESULT.addAll(List.of(ARR_A));
//        ARR_RESULT.addAll(List.of(ARR_B));
//
//        ARR_RESULT.sort(null);
//
//        for (long i : ARR_RESULT) {
//            SB.append(i).append(" ");
//        }
//    }

}