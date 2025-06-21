package 백트래킹.풀어야할문제.치킨배달_15686_골드5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;

    public static int MIN = Integer.MAX_VALUE;
    public static int[][] MAP;

    public static List<int[]> HOUSE_LIST = new ArrayList<>();
    public static List<int[]> CHICKEN_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());

                if (MAP[i][j] == 1) {
                    HOUSE_LIST.add(new int[]{i, j});
                }
                if (MAP[i][j] == 2) {
                    CHICKEN_LIST.add(new int[]{i, j});
                }
            }
        }

        chooseChickens(0, 0, new ArrayList<>());

        System.out.println(MIN);
    }

    private static void chooseChickens(int idx, int depth, List<int[]> selectedChickens) {
        if (depth == M) {
            MIN = Math.min(MIN, solution(selectedChickens));
            return;
        }

        if (idx == CHICKEN_LIST.size()) {
            return;
        }

        selectedChickens.add(CHICKEN_LIST.get(idx));
        chooseChickens(idx + 1, depth + 1, selectedChickens);

        selectedChickens.remove(selectedChickens.size() - 1);
        chooseChickens(idx + 1, depth, selectedChickens);
    }

    private static int solution(List<int[]> chickens) {
        int distance = 0;

        for (int[] house : HOUSE_LIST) {
            int min_distance = Integer.MAX_VALUE;

            for (int[] chicken : chickens) {
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                min_distance = Math.min(min_distance, dist);
            }

            distance += min_distance;
        }

        return distance;
    }

}
