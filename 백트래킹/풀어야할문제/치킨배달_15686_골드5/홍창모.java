package 백트래킹.풀어야할문제.치킨배달_15686_골드5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 홍창모 {

    static int N, M, len, answer = Integer.MAX_VALUE;

    static ArrayList<Point> house, chickenHouse;

    static int[] aliveCK;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chickenHouse = new ArrayList<>();

        for( int i = 0; i < N; i ++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < N; j++ ) {
                int tmp = Integer.parseInt(st.nextToken());
                if( tmp == 1 ) {
                    house.add( new Point(i,j) );
                } else  if( tmp == 2 ) {
                    chickenHouse.add( new Point(i,j) );
                }
            }
        }
        // 전체 치킨집의 수
        len = chickenHouse.size();

        aliveCK = new int[M];

        dfs(0,0);

        System.out.print(answer);
    }

    public static void dfs(int L, int s) {
        if( L == M ) {
            // 경우의수 조회용
            /*for( int x : aliveCK ) {
                System.out.print(x + " ");
            }*/

            // 거리의 합
            int sum = 0;

            for( Point h : house ) {
                // 가장 큰값으로 먼저 초기화(최소값을 구하기 위함)
                int minDistance = Integer.MAX_VALUE;
                for( int x : aliveCK ) {
                    // 거리의 최소값 세팅
                    minDistance = Math.min(minDistance, Math.abs(h.x - chickenHouse.get(x).x) + Math.abs(h.y - chickenHouse.get(x).y) );
                }
                sum += minDistance;
            }

            answer = Math.min(answer, sum);

        } else {
            // 전체 치킨집중 임의로 M개 선택 처리
            for( int i = s; i < len; i++ ) {
                // 치킨집의 좌표 정보 set
                aliveCK[L] = i;
                dfs(L+1, i+1);
            }
        }
    }

}
