package christmas.constant;

public class MenuPrinter {
    public static void printMenu() {
        printCategory("애피타이저", Menu.Appetizer.values());
        printCategory("메인", Menu.MainMenu.values());
        printCategory("디저트", Menu.Dessert.values());
        printCategory("음료", Menu.Beverage.values());
    }

    private static void printCategory(String categoryName, Menu.MenuCategory[] menuItems) {
        System.out.println("<" + categoryName + ">");
        for (int i = 0; i <menuItems.length; i++) {
            System.out.print(menuItems[i] + formatPrice(menuItems[i].getPrice()));
            if (i < menuItems.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    private static String formatPrice(int price) {
        return String.format("(%,d)", price);
    }

}
