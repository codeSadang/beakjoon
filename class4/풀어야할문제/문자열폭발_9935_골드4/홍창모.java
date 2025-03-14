package class4.풀어야할문제.문자열폭발_9935_골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홍창모 {

    static String target, bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = br.readLine();
        bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < target.length(); i++ ) {
            sb.append(target.charAt(i));
            if( sb.length() >= bomb.length() && sb.substring(sb.length()-bomb.length()).equals(bomb) ) {
                sb.delete(sb.length()-bomb.length(), sb.length());
            }
        }

        if( sb.length() == 0 ) System.out.println("FRULA");
        else System.out.println(sb);

    }
}
