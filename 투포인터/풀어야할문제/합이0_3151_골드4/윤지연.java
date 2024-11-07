package 투포인터.풀어야할문제.합이0_3151_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    세용액이랑 같은 문제인 줄 알았지만 다름
    배열에 같은 값의 원소가 존재함
     */
    static int N;
    static int[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        students = new int[N];

        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);
        twoPointer();
    }

    public static void twoPointer() {
        int count = 0;

        for (int i = 0; i < N - 2; i++) {
            int s = i + 1;
            int e = N - 1;
            while (s < e) {
                int sum = students[i] + students[s] + students[e];

                if (sum == 0) {
                    count++;
                    s++;
                } else if (sum < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(count);
    }
}
