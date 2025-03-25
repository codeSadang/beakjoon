package 구현.풀어야할문제.너의평점은_25206_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        double totalPoints = 0.0;
        double totalCredits = 0.0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credits = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                totalPoints += credits * gradeMap.get(grade);
                totalCredits += credits;
            }
        }

        double gpa = totalPoints / totalCredits;
        System.out.printf("%.6f\n", gpa);
    }
}