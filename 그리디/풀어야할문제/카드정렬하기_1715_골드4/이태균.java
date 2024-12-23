package 그리디.풀어야할문제.카드정렬하기_1715_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이태균 {

    public static int N;
    public static int[] CARD_LIST;

    public static List<Integer> RESULT = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        CARD_LIST = new int[N];

        for (int i = 0; i < N; i++) {
            CARD_LIST[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(CARD_LIST);

        int temp = CARD_LIST[0] + CARD_LIST[1];
        RESULT.add(temp);

        for (int i = 2; i < CARD_LIST.length; i++) {
            temp += CARD_LIST[i];
            RESULT.add(temp);
        }

        int sum = RESULT.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

}