package class4.풀어야할문제.N_Queen_9663_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N x N 인 체스판이 있다.
 *
 * Queen은 가로, 세로, 대각선으로 움직일 수 있다.
 *
 * 1. 임의의 Queen을 배치한다.
 * */
public class 홍창모2 {

    static class Point {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;

    static int[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 퀸의 개수
        N = Integer.parseInt(br.readLine());


    }
}
