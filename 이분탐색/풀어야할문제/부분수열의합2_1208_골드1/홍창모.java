package 이분탐색.풀어야할문제.부분수열의합2_1208_골드1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 홍창모 {

    static int N, S;
    static int[] arr;
    static ArrayList<Integer> lower, upper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lower = new ArrayList<>();
        upper = new ArrayList<>();

        // Divide the array into two halves
        dfs(0, N / 2, 0, lower);
        dfs(N / 2, N, 0, upper);

        // Sort the lists to use binary search
        Collections.sort(lower);
        Collections.sort(upper);

        // Count the number of valid pairs
        long count = 0;
        for (int sum : lower) {
            count += upperBound(upper, S - sum) - lowerBound(upper, S - sum);
        }

        // If S is 0, we need to subtract the empty subsequence case
        if (S == 0) count--;

        System.out.println(count);
    }

    // Generate all possible sums of subsequences
    public static void dfs(int start, int end, int sum, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        dfs(start + 1, end, sum, list);
        dfs(start + 1, end, sum + arr[start], list);
    }

    // Find the lower bound index
    public static int lowerBound(ArrayList<Integer> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= key) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    // Find the upper bound index
    public static int upperBound(ArrayList<Integer> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) > key) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}