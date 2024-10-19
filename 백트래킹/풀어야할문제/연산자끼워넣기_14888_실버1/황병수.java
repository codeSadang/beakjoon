package 백트래킹.풀어야할문제.연산자끼워넣기_14888_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {

    static int N;
    static int[] numList;
    static int[] operator;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numList = new int[N];
        String[] giveNum = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numList[i] = Integer.parseInt(giveNum[i]);
        }

        operator = new int[4];
        String[] giveOpera = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(giveOpera[i]);
        }

        backtracking(1, numList[0]);

        System.out.println(maxResult);
        System.out.println(minResult);

    }

    private static void backtracking(int count, int nowSum) {

        if (count == N) {
            maxResult = Math.max(maxResult, nowSum);
            minResult = Math.min(minResult, nowSum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                int tempSum = nowSum;
                switch (i) {
                    case 0 : tempSum += numList[count]; break;
                    case 1 : tempSum -= numList[count]; break;
                    case 2 : tempSum *= numList[count]; break;
                    case 3 : tempSum /= numList[count]; break;
                }

                backtracking(count + 1 ,tempSum);

                operator[i]++;
            }
        }
    }
}
