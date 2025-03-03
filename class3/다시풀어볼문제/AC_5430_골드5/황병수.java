package class3.다시풀어볼문제.AC_5430_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * AC 는 정부 배열에 연산을 하기 위해 만든 언어이다.
 * 이 언어에는 뒤집기(R) 버리기(D)가 있다.
 * R 은 배열에 있는 수의 순서를 뒤집는 함수
 * D 는 첫 번째 수를 버리는 함수
 * 배열이 비어있는데 D를 사용하면 에러 발생
 * 함수는 조합해서 한번에 사용할 수 있다. AB 는 A -> B
 */
public class 황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            // 수행할 일 목록
            String method = br.readLine();

            // 주어질 배열 크기
            int size = Integer.parseInt(br.readLine());

            // 주어진 배열
            String input = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            input = input.substring(1, input.length() - 1); // 대괄호 제거

            if (size > 0) { // 비어있지 않다면 값 저장
                String[] numbers = input.split(",");
                for (String num : numbers) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false; // 뒤집기 상태
            boolean isError = false; // 에러 발생 여부
            for (char cmd : method.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed; // 뒤집기 상태 변경
                } else { // 'D' 연산
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast(); // 뒤집힌 상태라면 뒤에서 삭제
                    } else {
                        deque.pollFirst(); // 일반 상태라면 앞에서 삭제
                    }
                }
            }

            // 결과 출력
            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}