package 백트래킹.풀어야할문제.카드놓기_5568_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 황병수 {
    static int N,K;
    static int[] cardList;
    static boolean[] visited;
    static Set<String> resultSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cardList = new int[N];
        visited = new boolean[N];

        for (int i = 0; i <N; i++) {
            cardList[i] = Integer.parseInt(br.readLine());
        }

        getCard(0, "");
        System.out.println(resultSet.size());
    }

    static void getCard(int count, String current) {

        if (count == K) {
            resultSet.add(current);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getCard(count + 1, current + cardList[i]);
                visited[i] = false;
            }
        }


    }
}
