package 프로그래머스.Lv2;

public class 할인행사 {

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int result = solution(want, number, discount);
        System.out.println(result);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        PurchaseChecklist checklist = new PurchaseChecklist(want, number);

        // 10일 단위로 슬라이딩 윈도우 체크
        for (int start = 0; start <= discount.length - 10; start++) {
            // 10일간의 할인 품목 추출
            String[] tenDaysDiscount = new String[10];
            System.arraycopy(discount, start, tenDaysDiscount, 0, 10);

            // 모든 제품 구매 가능하면 answer 증가
            if (checklist.checkPurchase(tenDaysDiscount)) {
                answer++;
            }
        }

        return answer;
    }
    // 구매 체크리스트 내부 클래스
    static class PurchaseChecklist {
        private String[] wants;
        private int[] requiredQuantities;

        public PurchaseChecklist(String[] wants, int[] requiredQuantities) {
            this.wants = wants;
            this.requiredQuantities = requiredQuantities.clone();
        }

        // 할인 상품 확인 및 구매 처리
        public boolean checkPurchase(String[] discountItems) {
            // 남은 구매 수량 복사본 생성
            int[] remainQuantities = requiredQuantities.clone();

            // 10일간의 할인 품목 체크
            for (String item : discountItems) {
                for (int i = 0; i < wants.length; i++) {
                    if (wants[i].equals(item)) {
                        remainQuantities[i]--;
                        break;
                    }
                }
            }

            // 모든 상품 구매 완료 여부 확인
            for (int remain : remainQuantities) {
                if (remain > 0) {
                    return false;
                }
            }
            return true;
        }
    }

}