package 백트래킹.풀어야할문제.감소하는수_1038_골드5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 황병수 {
    static List<Long> list = new ArrayList<>();
    static long result = -1;
    static int count = 0;  // 감소하는 수의 인덱스를 추적하기 위한 변수
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            return;
        }

        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < 10; i++) {
            DFS(i);
        }

        Collections.sort(list);

        System.out.println(list);
        System.out.println(list.get(N));
    }

    private static void DFS(long num) {
        list.add(num);
        long modValue = num % 10;

        if(modValue == 0) {
            return;
        }

        for(long i = modValue - 1; i >= 0; i--) {
            long newValue = num * 10 + i;
            DFS(newValue);
        }
    }
}
