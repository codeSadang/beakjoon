package 유니온파인드.풀어야할문제.공항_10775_골드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 신승원의 생일이다.
 * 박승원은 신스우언에게 공항을 선물로 줬다.
 * 공항에는 G개의 게이트가 있고, 각각 1에서 G까지 번호를 가지고 있다.
 * 공항에는 P개의 비행기가 순서대로 도착
 *
 * i번째 비행기를 1번부터 Gi번째 게이트중 하나에 영구적으로 도킹하려한다.
 * 비행기가 어느 게이트에 도킹할 수 없다면 공항이 폐쇠되고,
 * 이후 어떤 비행기도 도착할 수 없다.
 * 승원이는 비행기르 최대 몇대 도킹시킬 수 있는가?
 */
public class 황병수 {
    static int G,P,C;
    static int[] ListA;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        ListA = new int[G+1];
        for (int i = 0; i <= G; i++) {
            ListA[i] = i;
        }

        for (int i = 1; i <= P; i++) {
            int airplaneC = Integer.parseInt(br.readLine());
            int availableGate = Find(airplaneC);

            if (availableGate == 0) { // 도킹 가능한 게이트가 없으면 공항 폐쇄
                System.out.println(C);
                return;
            }

            Union(availableGate, 0); // 게이트를 사용한 후, 폐쇄
            C++; // 도킹된 비행기 수 증가

        }
        System.out.println(C);
    }

    private static int Find(int x) {
        if (x == ListA[x]) return x;
        return ListA[x] = Find(ListA[x]);
    }

    private static void Union(int x, int y) {
        x = Find(x);
        y = Find(y);

        if (x == y) return;
        if (x < y) {
            ListA[y] = x;
        } else {
            ListA[x] = y;
        }
    }
}
