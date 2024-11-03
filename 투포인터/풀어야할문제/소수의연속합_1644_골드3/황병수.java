package 투포인터.풀어야할문제.소수의연속합_1644_골드3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수
 *
 * 주어진 수 이하의 소수를 배열에 넣는다.
 *
 * 그리고 연속된 합으로 만든 값이 소수인지 확인
 */
public class 황병수 {

    static int N;
    static List<Integer> AList;
    static int count = 0;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        AList = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                AList.add(i);
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        while (true) {

            // N을 만드는 연속된 소수의 합을 찾았을 때
            if (sum == N) {
                count++;
                sum -= AList.get(left++);

            // 합이 N보다 크면 왼쪽 당기기
            } else if (sum > N) {
                sum -= AList.get(left++);

            // N보다 작고, right 가 소수 사이즈를 넘지 않았을 때
            } else if (right < AList.size()) {
                sum += AList.get(right++);

            // 만약에 right 가 소수 리스트 사이즈를 넘어가면 종료
            } else {
                break;
            }
        }

        System.out.println(count);
    }


    static boolean isPrime(int num) {

        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i*i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }


//    static boolean isCheck(int num) {
//        if (num <= 1) return false;
//        if (num <= 3) return true;
//        if (num % 2 == 0 || num % 3 == 0 ) return false;
//
//        for (int i = 5; i * i <= num; i+=6) {
//            if (num % i == 0 || num % (i + 2) == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
