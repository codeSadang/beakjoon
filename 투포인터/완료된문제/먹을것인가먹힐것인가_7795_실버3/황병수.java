package 투포인터.완료된문제.먹을것인가먹힐것인가_7795_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 심해에 두 종류에 생명체 A,B가 존재한다.
 *
 * A 는 B를 먹는다.
 *
 * A는 자기보다 크기가 작은 먹이만 먹을 수 있다.
 *
 * A {8, 1, 7, 3, 1 } 이고, B의 크기가 {3,6,1}인 경우 A가 B를 먹을 수 있는 쌍의 개수는 7가지
 *
 * A 를 target 으로 순차적으로 잡고
 *
 * Aindex Bindex 를 따로 선언하고
 * 사실 2중 for문이면 해결할 수 있는 문제이지만!!
 *
 * 우선 두개의 리스트를 오른차순으로 정렬한다.
 * 그리고 A인덱스
 */
public class 황병수 {

    static int N, ASize, BSize;
    static int[] AList, BList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int K = 0; K < N; K++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            ASize = Integer.parseInt(st.nextToken());
            BSize = Integer.parseInt(st.nextToken());

            AList = new int[ASize];
            BList = new int[BSize];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < ASize; i++) {
                AList[i] =Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < BSize; i++) {
                BList[i] =Integer.parseInt(st.nextToken());
            }

            Arrays.sort(AList);
            Arrays.sort(BList);

            int count = 0;
            for (int IndexA = 0; IndexA < ASize; IndexA++) {
                int IndexB = 0;
                while(IndexB < BSize && AList[IndexA] > BList[IndexB]) {
                    count++;
                    IndexB ++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
