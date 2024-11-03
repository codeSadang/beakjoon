package 백트래킹.완료된문제.근손실_18429_실버3;

/*
* 풀이
* 대학원생의 기본 중량은 500이다
* N일 동안 중량은 500이상이 되어야한다.
* N개의 키트가 주어진다.
* 하루동안 M의 근육량이 감소한다.
* 500 + arr[N-1] > 500 커야한다.
*
* 반복문을 통해 전체의 경우를 탐색한다. DFS
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모 {
    static int n, k;
    static int count=0;
    static int weight = 500;

    static int[] kit;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 키트의 수, 요일수
        n = Integer.parseInt(st.nextToken());
        // 하루동안 감소하는 근육량
        k = Integer.parseInt(st.nextToken());

        kit = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < n; i++ ) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, weight);

        System.out.print(count);
    }

    public static void dfs(int idx, int weight) {
        if( idx == n )  {
            count++;
            return;
        }
        if( weight < 500 ) return;

        for( int i = 0; i < n; i++ ) {
            if( !visited[i] ) {
                visited[i] = true;
                dfs(idx + 1, weight - k + kit[i]);
                visited[i] = false;
            }
        }
    }

}
