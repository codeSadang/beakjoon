package class1.풀어야할문제.숫자의개수_2577_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int abc = a * b * c;
        String[] str = String.valueOf(abc).split("");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(i, 0);
        }

        for (String s : str) {
            map.put(Integer.parseInt(s), map.getOrDefault(Integer.parseInt(s), 0) + 1);
        }

        for (Integer key : map.keySet()) {
            sb.append(map.get(key)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}