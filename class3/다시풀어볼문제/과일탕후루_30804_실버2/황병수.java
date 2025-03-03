package class3.다시풀어볼문제.과일탕후루_30804_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 황병수 {

    static HashMap<Integer, Integer> fruitCount = new HashMap<>();
    static int[] fruits;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, maxLength = 0;

        for (int right = 0; right < N; right++) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitCount.size() > 2) {
                // 왼쪽 과일 제거
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);

                // 만약에 제거 과일의 값이 0이면 아예 제거
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }

                // left 인덱스 이동
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);


    }
}
