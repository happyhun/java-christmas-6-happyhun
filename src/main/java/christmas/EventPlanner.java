package christmas;

import christmas.menu.Menu;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EventPlanner {

    private final List<Integer> specialDates = List.of(3, 10, 17, 24, 25, 31);

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final OrderCalculator orderCalculator = new OrderCalculator();
    private final PromotionManager promotionManager = new PromotionManager();
    private final PromotionDetail promotionDetail = new PromotionDetail();

    public void start() {
        OrderResult result = getOrderResult();
        printOrderResult(result);
    }

    private void printOrderResult(OrderResult result) {
        outputView.printPreviewMessage();
        outputView.printOrders(result.orders());
        outputView.printTotalPrice(result.totalPrice());
        outputView.printGiftMenus(result.giftMenus());
        outputView.printPromotionDetails(result.promotionDetails());
        outputView.printTotalDiscountAmount(result.totalDiscountAmount());
        outputView.printTotalPriceAfterDiscount(result.totalPrice() - result.totalDiscountAmount());
        outputView.printBadge(result.optionalBadge());
    }

    private OrderResult getOrderResult() {
        outputView.printWelcomeMessage();

        int date = inputView.readDate();
        Map<Menu, Integer> orders = inputView.readOrders();

        int totalPrice = orderCalculator.calculateTotalPrice(orders);
        Map<Menu, Integer> giftMenus = promotionManager.getGiftMenus(totalPrice);
        Map<Promotion, Integer> promotionDetails = promotionDetail.getPromotionDetails(orders, giftMenus, specialDates, date);
        int totalDiscountAmount = orderCalculator.calculateTotalDiscountAmount(promotionDetails);
        Optional<Badge> optionalBadge = promotionManager.getBadge(totalDiscountAmount);

        return new OrderResult(orders, totalPrice, giftMenus, promotionDetails, totalDiscountAmount, optionalBadge);
    }
}
