package lab1week7;

public class Main {

    public static void main(String[] args) {
        Customer c1 = new Customer("Ahmet Yılmaz", "05551112233", "Talas Bulvarı No:4", "Talas", "Kayseri");
        Customer c2 = new Customer("Ayşe Demir", "05324445566", "Sivas Caddesi No:12", "Melikgazi", "Kayseri");

        Coupon validCoupon = new Coupon("INDIRIM20", 0.20, 150.0);
        Coupon highRequirementCoupon = new Coupon("INDIRIM50", 0.50, 500.0);

        try {
            Order order1 = new Order(c1);
            order1.addItem(new MenuItem("Lahmacun", 60.0, 2));
            order1.addItem(new MenuItem("Lahmacun", 60.0, 1));
            order1.addItem(new MenuItem("Ayran", 15.0, 3));
            order1.applyCoupon(validCoupon);
            order1.checkout();

            Order order2 = new Order(c2);
            order2.addItem(new MenuItem("Pizza", 180.0, 1));
            order2.addItem(new MenuItem("Kola", 30.0, 2));
            order2.updateQuantity("Kola", 1);
            order2.removeItem("Pizza");
            order2.addItem(new MenuItem("Burger Menü", 120.0, 1));
            order2.applyCoupon(highRequirementCoupon);
            order2.checkout();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            new MenuItem("Tatlı", 50.0, 0);
        } catch (InvalidQuantityException e) {
            System.out.println("Hata Yakalandı: " + e.getMessage());
        }

        try {
            Order testOrder = new Order(c1);
            testOrder.removeItem("Döner");
        } catch (ItemNotFoundException e) {
            System.out.println("Hata Yakalandı: " + e.getMessage());
        }

        try {
            Order testOrder = new Order(c1);
            testOrder.addItem(new MenuItem("Su", 10.0, 1));
            testOrder.checkout();
        } catch (MinimumOrderException | InvalidQuantityException e) {
            System.out.println("Hata Yakalandı: " + e.getMessage());
        }

        System.out.println("\nTamamlanan Sipariş Sayısı: " + Order.getCompletedOrders());
        System.out.println("Toplam Gelir: " + Order.getTotalRevenue() + " TL");
    }
}
