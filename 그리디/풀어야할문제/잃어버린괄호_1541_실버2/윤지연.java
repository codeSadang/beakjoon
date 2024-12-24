package 그리디.풀어야할문제.잃어버린괄호_1541_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤지연 {
    /*마이너스가 나온 이후의 모든 수를 뺄셈하면 최솟값을 만들 수 있다.*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusChunk = br.readLine().split("-");

        int answer = getSum(minusChunk[0]);

        for (int i = 1; i < minusChunk.length; i++) {
            answer -= getSum(minusChunk[i]);
        }
        System.out.println(answer);
    }

    static int getSum(String expression) {
        String[] chunks = expression.split("\\+");
        int sum = 0;
        for (String chunk : chunks) {
            sum += Integer.parseInt(chunk);
        }
        return sum;
    }
}
