package 해시.풀어야할문제.회사에있는사람_7785_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 황병수 {
    static int N;
    static HashMap<String, String> mapA = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String enterLeave = st.nextToken();

            if (enterLeave.equals("enter")) {
                mapA.put(name, enterLeave);
            } else {
                mapA.remove(name);
            }
        }

        ArrayList<String> sortedNames = new ArrayList<>(mapA.keySet());
        Collections.sort(sortedNames, Collections.reverseOrder());

        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}
