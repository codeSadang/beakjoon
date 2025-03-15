package class4.풀어야할문제.사전순최대공통부분수열_30805_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 윤지연 {

    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> result = new ArrayList<>();
        int pointerA = 0, pointerB = 0;

        while (pointerA < N && pointerB < M) {
            boolean found = false;
            for (int candidate = 100; candidate >= 1; candidate--) {
                int indexA = findIndex(A, pointerA, candidate);
                int indexB = findIndex(B, pointerB, candidate);
                if (indexA != -1 && indexB != -1) {
                    result.add(candidate);
                    found = true;
                    pointerA = indexA + 1;
                    pointerB = indexB + 1;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        System.out.println(result.size());
        StringBuilder answer = new StringBuilder();
        for (int num : result) {
            answer.append(num).append(" ");
        }
        System.out.println(answer.toString().trim());
    }
    static int findIndex (int[] arr, int start, int candidate) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == candidate) {
                return i;
            }
        }
        return -1;
    }
}
