package 투포인터.완료된문제.두수의합_3273_실버3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class 황병수 {

    static int N, K;
    static int[] AList;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        AList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AList);

        K = Integer.parseInt(br.readLine());

        int left = 0;
        int right = N-1;
        int sum = 0;
        while(left < right) {
            sum = AList[left] + AList[right];
            if (sum == K) {
                count++;
                left++;
            } else if (sum < K) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
