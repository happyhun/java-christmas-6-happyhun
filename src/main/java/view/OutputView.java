package view;

import christmas.Promotion;
import christmas.menu.Menu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class OutputView {

    public void printOrders(Map<Menu, Integer> orders) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<Menu, Integer> order : orders.entrySet()) {
            System.out.printf("%s %d개\n", order.getKey().getName(), order.getValue());
        }
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
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

        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
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
}
