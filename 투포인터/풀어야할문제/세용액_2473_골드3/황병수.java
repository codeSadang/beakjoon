package 투포인터.풀어야할문제.세용액_2473_골드3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 양 끝에 용액을 선택한 후
 * 중간값부터 위 아래로 움직인다
 * 위 아래로 움직이다가 절대값이 더 커지는 순간이 오면
 * 해당 값을 선택한 것으로 판단
 * 좌측과 우측의 합이 0보다 크고 같으면 right--
 * 좌측과 우측의 합이 0보다 작으면 right++;
 */
public class 황병수 {

    static int N;
    static int[] AList;
    static long result = Long.MAX_VALUE;
    static int[] resultList = new int[3];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        AList = new int[N];

        for (int i = 0; i < N; i++) {
            AList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(AList);


        for (int i = 0; i < N-2; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {

                long sum = (long) AList[i] + AList[left] + AList[right];
                if (result > Math.abs(sum)) {
                    result = Math.abs(sum);
                    resultList[0] = AList[i];
                    resultList[1] = AList[left];
                    resultList[2] = AList[right];
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    System.out.println(resultList[0] +" "+ resultList[1] + " "+ resultList[2]);
                    return;
                }
            }
        }

        System.out.println(resultList[0] +" "+ resultList[1] + " "+ resultList[2]);
    }
}
