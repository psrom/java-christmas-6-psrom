
package christmas.constant;

public class MenuPrinter {
    public static void printMenu() {
        printLine();

        printCategory("애피타이저", Menu.애피타이저.values());
        printCategory("메인", Menu.메인.values());
        printCategory("디저트", Menu.디저트.values());
        printCategory("음료", Menu.음료.values());

        printLine();
    }

    private static void printCategory(String categoryName, Menu.MenuCategory[] menuItems) {
        System.out.println("<" + categoryName + ">");
        for (int i = 0; i <menuItems.length; i++) {
            System.out.print(menuItems[i] + formatPrice(menuItems[i].getPrice()));
            if (i < menuItems.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static String formatPrice(int price) {
        return String.format("(%,d)", price);
    }

    private static void printLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

}