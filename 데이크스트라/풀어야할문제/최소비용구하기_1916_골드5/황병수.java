package 데이크스트라.풀어야할문제.최소비용구하기_1916_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * N개의 도시가 있다.
 * 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스
 *
 * 우리는 A번째 도시에서 B도시까지 가는데 비용을 최소화!
 * A번쨰에서 B번쨰까지 가는데 드는 최소비용을 출력하라
 *
 * 도시의 번호는 1부터 N까지
 *
 * 첫째줄에 도시의 개수 N
 * 둘째줄에 버스의 개수 M
 * 셋째줄부터 M+2 줄까지 버스의 정보
 *
 * 출발 버스 지점 / 도착 버스 지점 / 버스 비용
 *
 * M+3 번째에는 우리가 구하고자 하는 구간의 출발점의 도시번호와 도착점의 도시번호가 주어짐!
 */
public class 황병수 {

    public static class PositionCost {
        private int sPos;
        private int ePos;
        private int cost;

        // 생성자
        public PositionCost(int sPos, int ePos, int cost) {
            this.sPos = sPos;
            this.ePos = ePos;
            this.cost = cost;
        }

        // Getter & Setter
        public int getsPos() {
            return sPos;
        }

        public void setsPos(int sPos) {
            this.sPos = sPos;
        }

        public int getePos() {
            return ePos;
        }

        public void setePos(int ePos) {
            this.ePos = ePos;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        // 객체 정보 출력용 toString()
        @Override
        public String toString() {
            return "PositionCost{" +
                    "sPos=" + sPos +
                    ", ePos=" + ePos +
                    ", cost=" + cost +
                    '}';
        }
    }
    static int[] result;
    static List<PositionCost> input = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        result = new int[N+1];
        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int sPoint = Integer.parseInt(st.nextToken());
            int ePoint = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            input.add(new PositionCost(sPoint, ePoint, cost));
        }

        // 실제로 구해야 할 시작값과 마지막 값
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sPoint = Integer.parseInt(st.nextToken());
        int ePoint = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {

            if (sPoint > i ) continue;
            if (ePoint < i ) continue;



        }
    }

}
