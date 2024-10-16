package 백트래킹.풀어야할문제.치킨배달_15686_골드5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 크기가 NxN 인 도시가 있음
 * 도시의 각 칸은 빈칸 / 치킨집 / 집 중 하나
 * 도시의 칸은 r행, c 열
 * r과 c는 1부터 시작한다.
 *
 * 치킨거리는 집과 가장 가까운 치킨집 사이의 거리 각각의 집은 치킨거리를 가지고 있고,
 * 도시의 치킨거리는 모든 집의 치킨거리의 합이다.
 *
 * 임이의 두칸 각 행차이 열차이를 더한 값의 합이다.
 *
 * 0 = 빈칸
 * 1 = 집
 * 2 = 치킨집
 *
 * 입력 받을 떄 치킨집 위치를 따로 저장해놔!!
 * 그리고 각 집을 순회하면서 치킨집마다
 *
 */
public class 황병수 {

    static int N,M;
    static int minDistance = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new int[] {i, j});
                if (map[i][j] == 2) chickens.add(new int[] {i, j});
            }
        }

        chooseChickens(0, 0, new ArrayList<>());
        System.out.println(minDistance);
    }

    private static void chooseChickens(int idx, int depth, List<int[]> selectedChickens) {
        if (depth == M) {
            minDistance = Math.min(minDistance, calculateDistance(selectedChickens));
            return;
        }

        if (idx == chickens.size()) return;

        selectedChickens.add(chickens.get(idx));
        chooseChickens(idx + 1, depth + 1, selectedChickens);

        selectedChickens.remove(selectedChickens.size() -1);
        chooseChickens(idx + 1, depth, selectedChickens);
    }

    private static int calculateDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (int[] selectedChicken : selectedChickens) {
                int dist = Math.abs(house[0] - selectedChicken[0]) + Math.abs(house[1] - selectedChicken[1]);
                minDist = Math.min(minDist, dist);
            }
            totalDistance += minDist;
        }

        return totalDistance;
    }
}
