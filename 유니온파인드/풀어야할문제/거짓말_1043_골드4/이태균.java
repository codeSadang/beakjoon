package 유니온파인드.풀어야할문제.거짓말_1043_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static int[] PARENT;
    public static boolean[] IS_KNOWN;

    public static List<List<Integer>> PARTY_LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PARENT = new int[N + 1];
        IS_KNOWN = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            PARENT[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int known_count = Integer.parseInt(st.nextToken());
        if (known_count > 0) {
            for (int i = 0; i < known_count; i++) {
                int known_number = Integer.parseInt(st.nextToken());
                IS_KNOWN[known_number] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int party_people_count = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            int first_person = -1;

            for (int j = 0; j < party_people_count; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);

                if (j == 0) {
                    first_person = person;
                } else {
                    union(first_person, person);
                }
            }

            PARTY_LIST.add(party);
        }

        for (int i = 1; i <= N; i++) {
            if (IS_KNOWN[i]) {
                int root = find(i);
                for (int j = 1; j <= N; j++) {
                    if (find(j) == root) {
                        IS_KNOWN[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for (List<Integer> party : PARTY_LIST) {
            boolean can_lie = true;
            for (int person : party) {
                if (IS_KNOWN[find(person)]) {
                    can_lie = false;
                    break;
                }
            }
            if (can_lie) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static int find(int node) {
        if (node != PARENT[node]) {
            return PARENT[node] = find(PARENT[node]);
        }
        return PARENT[node];
    }

    private static void union(int node, int node2) {
        int rootX = find(node);
        int rootY = find(node2);

        if (rootX != rootY) {
            PARENT[rootY] = rootX;
        }
    }

}