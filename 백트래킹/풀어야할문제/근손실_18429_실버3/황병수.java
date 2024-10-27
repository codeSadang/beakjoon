package 백트래킹.풀어야할문제.근손실_18429_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3대 운동 중량 500 소유

 * 하루마다 중량 k만큼 감소
 * k = 4 라면, 3일 후 12중량 감소

 * 운동을 하지않고 가만히 있으면 매일 감소

 * N개의 운동키트를 가지고 있는데, 하루에 1개씩의 키트를 사용
 * 운동 키트들은 각각의 중량 증가량을 가지고 있으며, 사용할 때마다 증량이 증가

 * 운동키트는 한번씩만 사용가능
 * 항상 중량이 500 이상으로 유지가 되도록 N일간의 운동 플랜을 세우려고 한다.
 * 어느 시점에서도 500보다 작아지면 안된다.

 * 1. 조건문 : 현재 중량이 500보다 미만이 되면 종료
 * 2. 조건문 : count 가 N일과 같다면 종료
 * 2-1 이때 result 값을 +1 해준다.
 */
public class 황병수 {

    static int N,K;
    static boolean[] visited;
    static int[] kit;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kit = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 500);

        System.out.println(result);
    }

    private static void backtracking(int count, int weight) {

        if (weight < 500) return;

        if (count == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(count + 1, weight - K + kit[i]);
                visited[i] = false;
            }
        }
    }
}
