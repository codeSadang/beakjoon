package 백트래킹.풀어야할문제.가르침_1062_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * ---------------------------문제-------------------------------
 * 선생님이 학생들에게 K개의 글자를 가르칠 시간밖에 없다.
 * 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다.
 * 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 될까!?

 * ---------------------------결론-------------------------------
 * 각 단어마다 테스트를 돌려야해 (현재 배운 글자로) -> 가장 큰 수를 찾기


 * ---------------------------풀이-------------------------------
 * 조건 1
 * -> 현재 배운 글자는 기본적으로 a,n,t,i,c 는 무조건 포함이야
 * -> 그럼 K값이 5미만이라면, 0이야 (사전에 차단)

 * 조건 2
 * -> anta / tica 는 항상 포함이므로, string 에서 앞뒤로 제거하고 남은 문자열을 character 로 split 한 후 중복없이 리스트에 담아
 * -> 그러면 총 배울 k글자 리스트가 나올거야. 그러면 이 중에서 k-5 만큼의 갯수만큼 중복이 되지 않게 골라내고,
 * -> 그 골라낸 배울 글자 k-5개를 가지고서 단어마다 테스트를 돌려
 * -> 테스트를 모두 돌려서 통과하는 갯수가 가장 큰값을 출력하면 됨.
 */
public class 황병수 {

    static int N,K;
    static int result = Integer.MIN_VALUE;
    static String[] strs;//학생들이 읽을 수 있는지 확인용 문장들을 담을 배열
    static boolean[] isTeached;//알파벳을 가르쳤는지 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        strs = new String[N];
        isTeached = new boolean[26];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            strs[i] = word.substring(4,word.length()-4);
        }

        isTeached['a' - 'a'] = true;
        isTeached['c' - 'a'] = true;
        isTeached['i' - 'a'] = true;
        isTeached['n' - 'a'] = true;
        isTeached['t' - 'a'] = true;

        backtracking(5,0);
        System.out.println(result);
    }

    static void backtracking(int depth, int idx) {
        if (depth == K) {
            check();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if(!isTeached[i]){
                isTeached[i] = true;
                backtracking(depth + 1, i);
                isTeached[i] = false;
            }
        }
    }

    private static void check() {//단어를 읽을 수 있나 체크하는 것.

        int canReadStrCnt = 0;
        for (int i = 0; i < N; i++) {
            int strslen = strs[i].length();
            boolean canRead = true;
            for (int j = 0; j < strslen; j++) {
                if (!isTeached[strs[i].charAt(j) - 'a']) {
                    canRead = false;
                    break;
                }
            }
            if(canRead) canReadStrCnt++;
        }
        result = Math.max(result, canReadStrCnt);
    }
}
