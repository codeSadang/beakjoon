package 백트래킹.풀어야할문제.계란으로계란치기_16987_골드5;

/**
 * 각 계란에는 내구도와 무게가 정해져있다.
 * 계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다.
 * 그리고 내구도가 0 이하가 되는 순간 계란은 깨지게 된다.
 * 예를 들어 계란 1의 내구도가 7, 무게가 5이고 계란 2의 내구도가 3, 무게가 4라고 해보자.
 * 계란 1으로 계란 2를 치게 되면 계란 1의 내구도는 4만큼 감소해 3이 되고 계란 2의 내구도는 5만큼 감소해 -2가 된다.
 * 충돌 결과 계란 1은 아직 깨지지 않았고 계란 2는 깨졌다.
 * <p>
 * 유현이가 인범이에게 알려준 퍼즐은 일렬로 놓여있는 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 문제였다.
 * 구체적으로 계란을 치는 과정을 설명하면 아래와 같다.
 */
/**
 * 1. 가장 왼쪽의 계란을 든다.
 * <p>
 * 2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
 * 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
 * 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
 * <p>
 * 3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
 * 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이 과정을 통해 최대한 많은 계란을 깨는 것이 앞으로 인범이가 매일 아침마다 풀게 될 퍼즐이다.
 * 그리고 유현이는 인범이가 찾은 답이 정답이 맞는지 확인해주려고 한다.
 * 일렬로 놓인 계란들의 내구도와 무게가 차례대로 주어졌을 때 최대 몇 개의 계란을 깰 수 있는지 알아맞춰보자.
 */
public class 이태균 {

    public static int N;
    public static int S;
    public static int W;

    public static Egg[] EGGS;
    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        EGGS = new Egg[N];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            EGGS[i] = new Egg(S, W);
        }

        backtracking(0);
        System.out.println(COUNT);
    }

    private static void backtracking(int now) {
        // 계란이 깨졌을 경우
        if (EGGS[now].durability <= 0) {
            backtracking(now + 1);
            return;
        }

        // 계란 치기 시작 1번씩 치기 때문에 반복문 사용
        for (int next = 0; next < N; next++) {
            // 혼자 깨기 안됨 + 내구도 정상이어야 함
            if (now != next && EGGS[next].durability > 0) {
                // 계란으로 계란을 치면 내구도는 무게만큼 깍임
                EGGS[now].durability -= EGGS[next].weight;
                EGGS[next].durability -= EGGS[now].weight;

                if (EGGS[now].durability <= 0) {
                    COUNT++;
                }
                if (EGGS[next].durability <= 0) {
                    COUNT++;
                }

                backtracking(now + 1);
            }



        }


    }

    private static class Egg {
        private int durability;
        private int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

}