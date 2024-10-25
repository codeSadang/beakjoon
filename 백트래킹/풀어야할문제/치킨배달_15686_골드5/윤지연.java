package 백트래킹.풀어야할문제.치킨배달_15686_골드5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 윤지연 {

    // 집의 좌표 리스트 저장
    // 치킨집 좌표 리스트

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Point> houses = new ArrayList<>();
    static List<Point> chickenShops = new ArrayList<>();
    static int N, M;
    static int minChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 처리
        N = sc.nextInt();
        M = sc.nextInt();

        // 도시 정보 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = sc.nextInt();
                if (value == 1) {
                    houses.add(new Point(i, j));
                } else if (value == 2) {
                    chickenShops.add(new Point(i, j));
                }
            }
        }

        // 2. M개의 치킨집을 고르는 조합을 구하고, 최소 치킨 거리를 계산
        combination(new ArrayList<>(), 0);

        // 3. 결과 출력
        System.out.println(minChickenDistance);
    }

    // 치킨집 조합을 구하는 함수 (백트래킹)
    static void combination(List<Point> selectedShops, int start) {
        // M개의 치킨집을 선택한 경우, 치킨 거리 계산
        if (selectedShops.size() == M) {
            int chickenDistance = calculateChickenDistance(selectedShops);
            minChickenDistance = Math.min(minChickenDistance, chickenDistance);
            return;
        }

        // 치킨집 선택 조합 만들기
        for (int i = start; i < chickenShops.size(); i++) {
            selectedShops.add(chickenShops.get(i));
            combination(selectedShops, i + 1); // 다음 치킨집 선택
            selectedShops.remove(selectedShops.size() - 1); // 백트래킹
        }
    }

    // 도시의 치킨 거리를 계산하는 함수
    static int calculateChickenDistance(List<Point> selectedShops) {
        int totalDistance = 0;

        // 모든 집에 대해 계산
        for (Point house : houses) {
            int minDistance = Integer.MAX_VALUE;

            // 선택된 각 치킨집과 집의 거리를 계산하여 최소값 찾기
            for (Point chickenShop : selectedShops) {
                int distance = Math.abs(house.r - chickenShop.r) + Math.abs(house.c - chickenShop.c);
                minDistance = Math.min(minDistance, distance);
            }

            // 해당 집의 최소 치킨 거리를 총합에 더함
            totalDistance += minDistance;
        }

        return totalDistance;
    }
}