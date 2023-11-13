package christmas.constant;

public class Menu {
    public interface MenuCategory {
        int getPrice();
    }

    public enum Appetizer implements MenuCategory{
        양송이수프(6000),
        타파스(5500),
        시저샐러드(8000);

        private final int price;

        Appetizer(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    public enum MainMenu implements MenuCategory {
        티본스테이크(55000),
        바비큐립(54000),
        해산물파스타(35000),
        크리스마스파스타(25000);

        private final int price;

        MainMenu(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    public enum Dessert implements MenuCategory {
        초코케이크(15000),
        아이스크림(5000);

        private final int price;

        Dessert(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    public enum Beverage implements MenuCategory {
        제로콜라(3000),
        레드와인(60000),
        샴페인(25000);

        private final int price;

        Beverage(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

}
