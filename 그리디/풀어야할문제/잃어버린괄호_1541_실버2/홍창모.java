package 그리디.풀어야할문제.잃어버린괄호_1541_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] minusSplit = str.split("-");

        int sum = 0;

        if( minusSplit.length > 1 ) {

            for( int i = 0; i < minusSplit.length; i++ ) {
                String[] plusSplit = minusSplit[i].split("\\+");

                int temp = 0;
                for( String plus : plusSplit ) {
                    temp += Integer.parseInt(plus, 10);
                }

                if( i == 0 ) {
                    sum += temp;
                } else {
                    sum -= temp;
                }
            }

        } else {
            String[] plusSplit = str.split("\\+");

            for( String plus : plusSplit ) {
                sum += Integer.parseInt(plus, 10);
            }
        }

        System.out.println(sum);
    }
}
