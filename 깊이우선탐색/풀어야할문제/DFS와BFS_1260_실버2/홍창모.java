package 깊이우선탐색.풀어야할문제.DFS와BFS_1260_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 홍창모 {

    static int N, M, V;

    static List<List<Integer>> list;

    static List<Integer> dfsList, bfsList;

    static boolean[] visitedA, visitedB;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dfsList = new ArrayList<>();
        bfsList = new ArrayList<>();

        visitedA = new boolean[N+1];
        visitedB = new boolean[N+1];

        for( int i = 0; i <= N; i++ ) {
            list.add(new ArrayList<>());
        }


        for( int i = 0; i < M; i++ ) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for( int i = 0; i<=N; i++ ) {
            Collections.sort(list.get(i));
        }

        dfs(V);

        for( int x : dfsList ) {
            System.out.print(x + " ");
        }
        System.out.println();
        bfs(V);

        for (int x : bfsList) {
            System.out.print(x + " ");
        }


    }

    public static void dfs( int currIndex ) {

        visitedA[currIndex] = true;
        dfsList.add(currIndex);

        for( int i=0; i< list.get(currIndex).size(); i++ ) {
            if( !visitedA[list.get(currIndex).get(i)] ) {
                dfs( list.get(currIndex).get(i) );
            }
        }

    }

    public static void bfs( int currIndex ) {

        visitedB[currIndex] = true;
        bfsList.add(currIndex);

        Queue<Integer> Q = new LinkedList();
        Q.offer(currIndex);

        while( !Q.isEmpty() ) {
            int x = Q.poll();

            for( int i=0; i<list.get(x).size(); i++ ) {
                if( !visitedB[list.get(x).get(i)] ) {
                    visitedB[list.get(x).get(i)] = true;
                    bfsList.add(list.get(x).get(i));
                    Q.offer(list.get(x).get(i));
                }
            }
        }


    }
}
