package 깊이우선탐색.풀어야할문제.바이러스_2606_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    static int COMPUTER_SIZE;
    static int LINKED_COMPUTER_SIZE;
    static int COUNT = 0;
    static List<Computer> computerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // pc 개수
        COMPUTER_SIZE = Integer.parseInt(br.readLine());
        // 연결된 pc 수
        LINKED_COMPUTER_SIZE = Integer.parseInt(br.readLine());
        // 컴퓨터 리스트 초기화 (1번부터 시작이므로 0번 인덱스는 사용하지 않음)
        for (int i = 0; i < COMPUTER_SIZE + 1; i++) {
            computerList.add(new Computer(i));
        }

        // 네트워크 상 pc 상태
        for (int i = 0; i < LINKED_COMPUTER_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int linked_id = Integer.parseInt(st.nextToken());

            // 양방향 연결
            computerList.get(id).linkedComputerIdList.add(linked_id);
            computerList.get(linked_id).linkedComputerIdList.add(id);
        }

        dfs(1);
        System.out.println(COUNT);
    }

    private static void dfs(int id) {
        Computer computer = computerList.get(id);

        // 이미 감염된 컴퓨터는 다시 방문하지 않음
        if (computer.isVirus) {
            return;
        }

        // 현재 컴퓨터를 감염시킴
        computer.isVirus = true;

        // 1번 컴퓨터는 카운트에서 제외해야 하므로 체크
        if (id != 1) {
            // 감염된 컴퓨터 수 증가
            COUNT++;
        }

        // 연결된 컴퓨터들에 대해 재귀적으로 DFS 수행
        for (Integer linkedId : computer.linkedComputerIdList) {
            dfs(linkedId);
        }
    }

    static class Computer {
        public int id;
        public List<Integer> linkedComputerIdList;
        public boolean isVirus;

        public Computer(int id) {
            this.id = id;
            this.linkedComputerIdList = new ArrayList<>();
            this.isVirus = false;
        }
    }

}