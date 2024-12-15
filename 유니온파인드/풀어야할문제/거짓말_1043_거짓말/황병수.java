package 유니온파인드.풀어야할문제.거짓말_1043_거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  지민이가 있는 여러 파티를 방문할건데
 *  방문 하는 파티에 있는 그룹에 진실을 아는 사람이 있으면 거짓말을 할 수 없다 .
 *  거짓말 할 수 있는 그룹의 수는?
 */
public class 황병수 {

    static int N,M,C;
    static int[] ListA;
    static HashMap<Integer, ArrayList<Integer>> partyMemberList = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ListA = new int[N+1];
        for (int i = 1; i <= N; i++) {
            ListA[i] = i;
        }

        for (int i = 0; i < M; i++) {
            partyMemberList.put(i, new ArrayList<Integer>());
        }

        st = new StringTokenizer(br.readLine());
        int  knowLength = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowLength; i++) {
            int findNumber = Integer.parseInt(st.nextToken());
            ListA[findNumber] = 0;
        }

        // 파티 구성 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            ArrayList<Integer> partyMembers = partyMemberList.get(i);

            int firstMember = Integer.parseInt(st.nextToken());
            partyMembers.add(firstMember);

            int prevMember = firstMember;
            for (int j = 1; j < partySize; j++) {
                int nowMember = Integer.parseInt(st.nextToken());
                Union(prevMember, nowMember); // 모든 파티원을 같은 그룹으로 연결
                prevMember = nowMember;
                partyMembers.add(prevMember);
            }
        }

        // 거짓말 가능한 파티 수 계산
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> partyMembers = partyMemberList.get(i);
            for (Integer member : partyMembers) {
                if (isUnion(0, member)) { // 진실을 아는 사람과 연결된 경우
                    break;
                } else {
                    C++; // 거짓말할 수 있는 파티로 카운트
                    break;
                }
            }
        }
        System.out.println(C);
    }

    static int Find(int x) {
        if (x == ListA[x]) return x;
        return ListA[x] = Find(ListA[x]);
    }

    static void Union(int x, int y) {
        x = Find(x);
        y = Find(y);

        if (x == y) return;
        if (x < y) {
            ListA[y] = x;
        } else {
            ListA[x] = y;
        }
    }
    static boolean isUnion(int x, int y) {
        x = Find(x);
        y = Find(y);
        return (x==y);
    }
}
