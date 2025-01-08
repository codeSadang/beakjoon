package 다이나믹프로그래밍.풀어야할문제.Bunnies_26529_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 황병수 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

//        ArrayListMethod(br, sb);
        ListMethod(br, sb);
    }


    private static void ArrayListMethod(BufferedReader br, StringBuilder sb) throws IOException {

        List<Long> ListA = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        ListA.add(1L);
        ListA.add(1L);

        for (int i = 0; i < N; i++) {
            int nowCnt = Integer.parseInt(br.readLine());

            while (ListA.size() <= nowCnt) {
                long nextValue = ListA.get(ListA.size() - 1) + ListA.get(ListA.size() - 2);
                ListA.add(nextValue);
            }
            sb.append(ListA.get(nowCnt)).append('\n');

        }
        System.out.println(sb);
    }

    private static void ListMethod(BufferedReader br, StringBuilder sb) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int maxCnt = 2;
        int[] ListA = new int[46];

        ListA[0] = 1;
        ListA[1] = 1;

        for (int i = 0; i < N; i++) {
            int nowCnt = Integer.parseInt(br.readLine());

            while (maxCnt <= nowCnt) {
                ListA[maxCnt] = ListA[maxCnt-1] + ListA[maxCnt-2];
                maxCnt++;
            }

            sb.append(ListA[nowCnt]).append('\n');

        }
        System.out.println(sb);
    }
}
