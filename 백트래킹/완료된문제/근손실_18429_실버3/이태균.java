package 백트래킹.완료된문제.근손실_18429_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    // 운동 키트 수 및 사용 가능한 날짜
    public static int N;
    // 매일 근손실 수치
    public static int K;

    // 운동 키트의 근성장 값
    public static int[] HEALTH_GROWTH;
    public static boolean[] VISITED;

    public static int COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 운동 키트 및 근손실 값 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 근성장 값 초기화
        HEALTH_GROWTH = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            HEALTH_GROWTH[i] = Integer.parseInt(st.nextToken());
        }
        // 방문 여부 초기화
        VISITED = new boolean[N];

        // 백트래킹 함수 시작 (sbd: 초기 중량 500, depth: 0)
        backtracking(500, 0);

        System.out.println(COUNT);
    }

    private static void backtracking(int sbd, int depth) {
        // 최종일자 도달한 경우에 카운팅
        if (depth == N) {
            COUNT++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // 금일 근손실 및 근성장 계산 후 500보다 크거나 같아야 함
            if (!VISITED[i] && (sbd - K + HEALTH_GROWTH[i]) >= 500) {
                // 방문 후 다시 백트래킹 시도
                VISITED[i] = true;
                backtracking(sbd - K + HEALTH_GROWTH[i], depth + 1);

                // 백트래킹 종료 후 방문 취소
                VISITED[i] = false;
            }
        }
    }
}