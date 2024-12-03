package 해시.풀어야할문제.나는야포켓몬마스터이다솜_1620_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 이태균 {

    public static int N;
    public static int M;
    public static Map<String, Integer> POCKETMON_NAME = new HashMap<>();
    public static Map<Integer, String> POCKETMON_NUMBER = new HashMap<>();

    public static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            POCKETMON_NAME.put(str, i);
            POCKETMON_NUMBER.put(i, str);
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(49 <= str.charAt(0) && str.charAt(0) <= 57) {
                SB.append(POCKETMON_NUMBER.get(Integer.parseInt(str))).append("\n");
            }else {
                SB.append(POCKETMON_NAME.get(str)).append("\n");
            }
        }

        System.out.println(SB.toString());
    }

}