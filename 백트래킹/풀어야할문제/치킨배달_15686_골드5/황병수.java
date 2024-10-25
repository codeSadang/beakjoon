package 백트래킹.풀어야할문제.치킨배달_15686_골드5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
