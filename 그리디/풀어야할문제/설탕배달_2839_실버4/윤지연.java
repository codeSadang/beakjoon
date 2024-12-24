package 그리디.풀어야할문제.설탕배달_2839_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = count(N);
        System.out.println(answer);
    }

    static int count(int N) {
        int fiveCount = N / 5;

        while (fiveCount >= 0) {
            int remaining = N - (fiveCount * 5);

            if (remaining % 3 == 0) {
                int threeCount = remaining / 3;
                return fiveCount + threeCount;
            }

            fiveCount--;
        }
        return -1;
    }
}