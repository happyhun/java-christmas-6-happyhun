package view;

import christmas.Badge;
import christmas.Promotion;
import christmas.menu.Menu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class OutputView {

    private final NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);

    public void printOrders(Map<Menu, Integer> orders) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<Menu, Integer> order : orders.entrySet()) {
            System.out.printf("%s %d개\n", order.getKey().getName(), order.getValue());
        }
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        String formattedAmount = formatter.format(totalPrice);
        System.out.println(formattedAmount + "원\n");
    }

    public void printGiftMenus(Map<Menu, Integer> orders) {
        System.out.println("<증정 메뉴>");
        if (orders.isEmpty()) {
            System.out.println("없음");
        }

        for (Map.Entry<Menu, Integer> order : orders.entrySet()) {
            System.out.printf("%s %d개\n", order.getKey().getName(), order.getValue());
        }
        System.out.println();
    }

    public void printPromotionDetails(Map<Promotion, Integer> promotionDetails) {
        System.out.println("<혜택 내역>");
        if (promotionDetails.isEmpty()) {
            System.out.println("없음");
        }

        for (Map.Entry<Promotion, Integer> detail : promotionDetails.entrySet()) {
            if (detail.getValue() == 0) {
                continue;
            }
            String name = detail.getKey().getName();
            String formattedAmount = formatter.format(detail.getValue());
            System.out.printf("%s: -%s원\n", name, formattedAmount);
        }
        System.out.println();
    }

    public void printTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println("<총혜택 금액>");
        String formattedAmount = formatter.format(totalDiscountAmount);
        if (totalDiscountAmount > 0) {
            formattedAmount = "-" + formattedAmount;
        }
        System.out.println(formattedAmount + "원");
    }

    public void printTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        String formattedAmount = formatter.format(totalPriceAfterDiscount);
        System.out.println(formattedAmount + "원");
        System.out.println();
    }

    public void printBadge(Optional<Badge> optionalBadge) {
        System.out.println("<12월 이벤트 배지>");
        if (optionalBadge.isEmpty()) {
            System.out.println("없음");
        }
        if (optionalBadge.isPresent()) {
            System.out.println(optionalBadge.get().getName());
        }
    }

    public void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printPreviewMessage() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }
}
