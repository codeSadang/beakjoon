import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read first sequence
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // Read second sequence
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // Find lexicographically maximum common subsequence
        List<Integer> result = findLexMaxCommonSubsequence(A, B);

        // Print result
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        if (result.size() > 0) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static List<Integer> findLexMaxCommonSubsequence(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        int startA = 0;
        int startB = 0;

        while (true) {
            // Find maximum value that appears in both sequences
            int maxVal = -1;
            int maxIdxA = -1;
            int maxIdxB = -1;

            for (int i = startA; i < A.length; i++) {
                for (int j = startB; j < B.length; j++) {
                    if (A[i] == B[j] && A[i] > maxVal) {
                        maxVal = A[i];
                        maxIdxA = i;
                        maxIdxB = j;
                    }
                }
            }

            // If no common element is found, we're done
            if (maxVal == -1) {
                break;
            }

            // Add the found maximum value to the result
            result.add(maxVal);

            // Update starting positions for next search
            startA = maxIdxA + 1;
            startB = maxIdxB + 1;
        }

        return result;
    }
}