package 구현.풀어야할문제.기적의매매법_20546_실버5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 준현이는 한번 산 주식은 절대 팔지 않는다.
 *
 * 주식은 살 수 있다면, 최대한 많이 산다.
 *
 * 모든 거래는 전량 매수와 전량매도로만 이루어진다.
 * 현금이 100원 주가가 11원이면 99원어치 주식을 매수
 * 단 내가 있는 돈 내에서만 살 수 있음.
 *
 * 3일 연속 전일대비 상승하는 주식은 다음날 무조건 하락한다.
 * 따라서 현재 소유한 주식이 3일째 상승한다면 전량 매도
 * 전일과 오늘은 주가가 동일하다면 상승한게 아님.

 * 3일 연속 가격이 전일 대비 하락하는 주식은, 무조건 가격이 상승한다고 가정한다.
 * 이러한 경향이 나타나면 즉시 주식을 전량 매수한다.
 * 마찬가지로 전일과 주가가 동일하면 하락한게 아님
 *
 */
public class 황병수 {

    static int[] moneyA = new int[2];
    static int[] moneyB = new int[2];
    static int[] day = new int[14];
    static int increaseCount = 0;
    static int decreaseCount = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        moneyA[0] = moneyB[0] = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            day[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 13; i++) {
            allBuy(moneyA, day[i]);

            if (i > 0) {
                increaseCount = (day[i] > day[i - 1]) ? increaseCount + 1 : 0;
                decreaseCount = (day[i] < day[i - 1]) ? decreaseCount + 1 : 0;

                // 3일 연속 상승 시 전량 매도
                if (increaseCount >= 3) allSell(moneyB, day[i]);
                // 3일 연속 하락 시 전량 매수
                if (decreaseCount >= 3) allBuy(moneyB, day[i]);
            }
        }
        allSell(moneyA, day[13]);
        allSell(moneyB, day[13]);

        if (moneyA[0] > moneyB[0]) System.out.println("BNP");
        if (moneyA[0] < moneyB[0]) System.out.println("TIMING");
        if (moneyA[0] == moneyB[0]) System.out.println("SAMESAME");
    }

    static void allBuy(int[] money, int nowPrice) {
        if (nowPrice > 0) {
            money[1] += money[0] / nowPrice;
            money[0] = money[0] % nowPrice;
        }
    }

    static void allSell(int[] money, int nowPrice) {
        money[0] += money[1] * nowPrice;
        money[1] = 0;
    }
}
