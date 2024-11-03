package 투포인터.풀어야할문제.소수의연속합_1644_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 홍창모 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        // 소수를 List에 저장
        List<Integer> prime = toPrime(arr, n);

        // 소수의 합 비교
        System.out.print(twoPoint(prime, n));
    }

    public static int twoPoint( List<Integer> prime, int n ) {
        int answer = 0;

        int lt = 0, rt = 0, sum = 0;

        while ( rt < prime.size() ) {

            sum += prime.get(rt++);

            while( sum > n && lt < rt ) {
                sum -= prime.get(lt++);
            }

            if( sum == n ) {
                answer++;
            }
        }

        return answer;
    }

    public static List<Integer> toPrime( int[] arr, int n ) {
        int[] ch = new int[n+1];

        List<Integer> prime = new ArrayList<>();

        for( int i = 2; i <= n; i++ ) {
            if( ch[i] == 0 ) {
                prime.add(i);
                for( int j = i; j <= n; j+=i ) {
                    ch[j] = 1;
                }
            }
        }

        return prime;

    }

}
