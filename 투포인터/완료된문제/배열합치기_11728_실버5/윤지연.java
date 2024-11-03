package 투포인터.완료된문제.배열합치기_11728_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N;
    static int M;
    static List<Long> A = new ArrayList<>();
    static List<Long> B = new ArrayList<>();
    static List<Long> sortArr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Long.parseLong(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(Long.parseLong(st.nextToken()));
        }

        // 출력
        twoPointer(A, B);
        for (Long el: sortArr) {
            System.out.print(el);
            System.out.print(" ");
        }
    }
    
    public static void twoPointer(List<Long> A, List<Long> B) {
        int a = 0;
        int b = 0;

        while (a + b < N + M) {
            if (a == N) {
                sortArr.add(B.get(b));
                b++;
                continue;
            }
            if (b == M) {
                sortArr.add(A.get(a));
                a++;
                continue;
            }
            if (A.get(a) <= B.get(b)) {
                sortArr.add(A.get(a));
                a++;
            } else if (A.get(a) > B.get(b)) {
                sortArr.add(B.get(b));
                b++;
            }
        }
    }
}
