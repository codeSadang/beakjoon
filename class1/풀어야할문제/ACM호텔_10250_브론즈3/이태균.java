package class1.풀어야할문제.ACM호텔_10250_브론즈3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이태균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (int i = 1; i <= w; i++) {
                for (int j = 1; j <= h; j++) {
                    int room = (j * 100) + i;
                    cnt++;

                    if (n == cnt) {
                        sb.append(room).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }

}