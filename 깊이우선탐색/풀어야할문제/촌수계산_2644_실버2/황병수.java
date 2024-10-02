package 깊이우선탐색.풀어야할문제.촌수계산_2644_실버2;


/**
 * 우리나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
 * 촌수는 다음과 같은 방식으로 계산된다.
 *
 * 부모 자식들 간의 관계가 주어졌을 때 주어진 두 사람의 촌수를 계산하는 프로그램 작성
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 사람들은 1... 100이하 연속된 번호로 표시 된다.
 * 첫째 줄은 전체 사람의 수 n
 * 둘째 줄은 촌수를 계산해야 하는 서로 다른 두 사람의 번호
 *
 * 셋째 줄에는 부모 자식들간의 관계의 개수 m이 주어진다.
 */
public class 황병수 {

    static int targetA;
    static int targetB;
    static int[][] visited;
    static List<List<Integer>> family;
    static int totalCnt;
    static int QCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 사람 수
        totalCnt = Integer.parseInt(br.readLine());


        // 찾으려는 사람 각각 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        targetA = Integer.parseInt(st.nextToken());
        targetB = Integer.parseInt(st.nextToken());

        // 앞으로 나올 관계 수
        QCnt = Integer.parseInt(br.readLine());

        visited = new int[totalCnt][totalCnt];

        for (int i = 0; i < QCnt; i++) {

        }
    }

    static void bfs() {

    }
}
