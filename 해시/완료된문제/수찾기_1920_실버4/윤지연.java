package 해시.완료된문제.수찾기_1920_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 윤지연 {
    static int N, M;
    static HashSet<Integer> aArr = new HashSet<>();
    static int[] bArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aArr.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        bArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            bArr[j] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < M; k++) {
            checkContain(bArr[k]);
        }
    }

    static void checkContain(int target) {
        if (aArr.contains(target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
