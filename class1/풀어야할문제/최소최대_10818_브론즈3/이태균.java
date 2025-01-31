package class1.풀어야할문제.최소최대_10818_브론즈3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }

        sb.append(list.stream().mapToInt(Integer::intValue).min().getAsInt());
        sb.append(" ");
        sb.append(list.stream().mapToInt(Integer::intValue).max().getAsInt());

        System.out.println(sb);
    }

}