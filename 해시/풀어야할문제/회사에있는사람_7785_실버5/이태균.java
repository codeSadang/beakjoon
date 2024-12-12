package 해시.풀어야할문제.회사에있는사람_7785_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이태균 {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Set<String> employees = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                employees.add(name);
            } else {
                employees.remove(name);
            }
        }

        ArrayList<String> result = new ArrayList<>(employees);
        result.sort(Collections.reverseOrder());

        for (String name : result) {
            System.out.println(name);
        }
    }

}