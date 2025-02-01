package 다이나믹프로그래밍.시험볼문제.평범한배낭_12865_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 황병수 {
    static int[] bp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        bp = new int[maxWeight+1];

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());


            for (int j = maxWeight; j >= weight; j--) {
                bp[j] = Math.max(bp[j], bp[j-weight] + value);
            }
        }

        System.out.println(bp[maxWeight]);


    }

}
