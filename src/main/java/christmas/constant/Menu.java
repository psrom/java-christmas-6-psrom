package christmas.constant;

public class Menu {
    public interface MenuCategory {
        int getPrice();
    }

    public enum 애피타이저 implements MenuCategory{
        양송이수프(6000),
        타파스(5500),
        시저샐러드(8000);

        private final int price;

        애피타이저(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    public enum 메인 implements MenuCategory {
        티본스테이크(55000),
        바비큐립(54000),
        해산물파스타(35000),
        크리스마스파스타(25000);

        private final int price;

        메인(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    public enum 디저트 implements MenuCategory {
        초코케이크(15000),
        아이스크림(5000);

        private final int price;

        디저트(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    public enum 음료 implements MenuCategory {
        제로콜라(3000),
        레드와인(60000),
        샴페인(25000);

        private final int price;

        음료(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

}