package christmas.model;

import java.util.HashMap;
import java.util.Map;

import static christmas.constant.ErrorDetail.DUPLICATE_ERROR;
import static christmas.constant.ErrorDetail.ORDER_ERROR;
import static christmas.model.OrderValidator.checkOrder;

public class RequestOrder {

    private final Map<String, Integer> validatedOrder;

    public RequestOrder(String orders) {
        this.validatedOrder = checkOrder(splitOrders(orders));
    }

    private Map<String, Integer> splitOrders(String order) {
        Map<String, Integer> splitMenu = new HashMap<>();

        String[] orderParts = order.split(",");
        for (String part : orderParts) {
            String[] itemParts = part.strip().split("-");

            String menu = extractMenu(itemParts);
            Integer quantity = extractQuantity(itemParts);

            validateDuplicate(splitMenu, menu);

            splitMenu.put(menu, quantity);
        }
        return splitMenu;
    }

    private String extractMenu(String[] itemParts) {
        try {
            return itemParts[0].strip();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ORDER_ERROR.getMessage());
        }
    }

    private Integer extractQuantity(String[] itemParts) {
        try {
            return convertType(itemParts[1].strip());
        } catch (ArrayIndexOutOfBoundsException | UnsupportedOperationException e) {
            throw new IllegalArgumentException(ORDER_ERROR.getMessage());
        }
    }

    private void validateDuplicate(Map<String, Integer> splitMenu, String menu) {
        if (splitMenu.containsKey(menu)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR.getMessage());
        }
    }

    private Integer convertType(String quantity) {
        try {
            return Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ORDER_ERROR.getMessage());
        }
    }

}
