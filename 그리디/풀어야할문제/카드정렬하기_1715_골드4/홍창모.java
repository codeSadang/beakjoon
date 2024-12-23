package 그리디.풀어야할문제.카드정렬하기_1715_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 홍창모 {

    static int N ;

    static int[] cardList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cardList = new int[N];

        for( int i = 0; i < N; i++ ) {
            cardList[i] = Integer.parseInt(br.readLine());
        }

        // 정렬 해준다.
        Arrays.sort(cardList);

        int answer = 0;
        int a = 0, b = 0, sum = 0;

        for( int i = 0; i < N-1; i++ ) {
            a = cardList[i];
            b = cardList[i+1];

            sum = a + b;
            answer += sum;
            cardList[i+1] = sum;
        }

        System.out.println(answer);
    }
}
