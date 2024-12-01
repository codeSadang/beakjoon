package 해시.풀어야할문제.나는야포켓몬마스터이다솜_1620_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 윤지연 {
    /*
    * N: 도감 개수
    * M: 문제 개수
    * 2 ~ N + 1: 도감 목록
    * N + 2 ~ 마지막(M개): 문제 목록
    * 출력: 문제 목록에 맞는 답을 각 줄마다 출력
    * ---
    * 도감을 HashMap으로 만든다.(주의: 1번부터 입력)
    * 문제 목록 입력 시 문자인가 숫자인가 구분후 출력
    *   문자라면 포켓몬 숫자
    *   숫자라면 포켓몬 이름*/

    static int N, M;
    static Map<String, Integer> pokemonName = new HashMap<>();
    static Map<Integer, String> pokemonNumber = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String keyValue = br.readLine();
            pokemonName.put(keyValue, i);
            pokemonNumber.put(i, keyValue);
        }

        for (int j = 0; j < M; j++) {
            String problemValue = br.readLine();
            if (Character.isDigit(problemValue.charAt(0))) {
                Integer number = Integer.parseInt(problemValue);
                System.out.println(pokemonNumber.get(number));
            } else {
                System.out.println(pokemonName.get(problemValue));
            }
        }
    }
}
