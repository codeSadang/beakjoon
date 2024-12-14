//package 유니온파인드.풀어야할문제.사이클게임_20040_골드4;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
///**
// * 두명의 플레이어가 차례대로 돌아가며 진행하는 게임
// * 선 플레이어가 홀수 번 차례
// * 후 플레이어가 짝수 번 차례
// *
// * 게임 시작 시 0부터 n-1 까지 고유한 번호가 부여된 평면 상의 점 n개가 주어지며,
// * 이 중 어느세점도 일직선 위에 놓이지 않는다.
// * 매 차례 마다 플레이어는 두 점을 선택해서 이를 연결하는 선분을 긋는데 이전에 그린 선분을 다시 이을 수는 없지만
// * 다른 선분과 교차하는것은 가능하다.
// * 게임을 진행하다가 처음으로 사이클을 완성하는 순간 게임은 종료된다.
// *
// * 게임을 진행하다가 사이클이 완성되는 순간 게임 종료
// */
//public class 황병수 {
//    static int N,M;
//    static int[] ListA;
//    static int result = 0;
//    static HashMap<Integer, Integer> cycle = new HashMap<>();
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        ListA = new int[N];
//        for (int i = 0; i < N; i++) {
//            ListA[i] = i;
//            cycle.put(i,0);
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            // union
//            Union(a,b);
//
//        }
//
//        System.out.println(0);
//    }
//
//    static int Find(int x) {
//        if (x == ListA[x]) return x;
//        return ListA[x] = Find(ListA[x]);
//    }
//
//    static void Union(int x, int y) {
//        x = Find(x);
//        y = Find(y);
//
//        if (x == y) return;
//        if (x < y) {
//            ListA[y] = x;
//       } else {
//            ListA[x] = y;
//       }
//
//        int max = Math.max(cycle.get(x)+1, cycle.get(y)+1);
//        cycle.put(x, max);
//        cycle.put(y, max);
//
//        if (max >= 4) {
//            System.out.println(index);
//        }
//    }
//}
