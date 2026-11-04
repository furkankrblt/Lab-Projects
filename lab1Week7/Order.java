/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week7;

/**
 *
 * @author mfkar
 */
import java.util.ArrayList;

public class Order {

    private static int nextOrderNumber = 1001;
    public static final double MIN_ORDER = 100.0;
    public static final double DELIVERY_FEE = 20.0;
    private static int completedOrders = 0;
    private static double totalRevenue = 0.0;

    private int orderNumber;
    private Customer customer;
    private ArrayList<MenuItem> items;
    private Coupon coupon;
    private boolean isCompleted;

    public Order(Customer customer) {
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.coupon = null;
        this.isCompleted = false;
    }

    public void addItem(MenuItem item) throws InvalidQuantityException {
        for (MenuItem existing : items) {
            if (existing.getName().equalsIgnoreCase(item.getName())) {
                existing.setQuantity(existing.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(new MenuItem(item));
    }

    public void removeItem(String name) throws ItemNotFoundException {
        MenuItem target = null;
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                target = item;
                break;
            }
        }
        if (target == null) {
            throw new ItemNotFoundException("Ürün bulunamadı: " + name);
        }
        items.remove(target);
    }

    public void updateQuantity(String name, int quantity) throws ItemNotFoundException, InvalidQuantityException {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(quantity);
                return;
            }
        }
        throw new ItemNotFoundException("Ürün bulunamadı: " + name);
    }

    public double getSubtotal() {
        double subtotal = 0.0;
        for (MenuItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public ArrayList<MenuItem> getItems() {
        ArrayList<MenuItem> copy = new ArrayList<>();
        for (MenuItem item : items) {
            copy.add(new MenuItem(item));
        }
        return copy;
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public double checkout() throws MinimumOrderException {
        if (isCompleted) {
            return 0.0;
        }

        double subtotal = getSubtotal();
        if (subtotal < MIN_ORDER) {
            throw new MinimumOrderException("Minimum sipariş tutarı " + MIN_ORDER + " TL'dir.");
        }

        double discount = 0.0;
        if (coupon != null && subtotal >= coupon.getMinSubtotal()) {
            discount = subtotal * coupon.getDiscountRate();
        }

        double total = (subtotal - discount) + DELIVERY_FEE;

        completedOrders++;
        totalRevenue += total;
        isCompleted = true;

        printReceipt(subtotal, discount, total);
        return total;
    }

    private void printReceipt(double subtotal, double discount, double total) {
        System.out.println("============== SİPARİŞ FİŞİ ==============");
        System.out.println("Sipariş No: " + orderNumber);
        System.out.println("Müşteri: " + customer.getName());
        System.out.println("Teslimat Adresi: " + customer.getAddress());
        System.out.println("---------------- Ürünler -----------------");
        for (MenuItem item : items) {
            System.out.println(" - " + item);
        }
        System.out.println("------------------------------------------");
        System.out.printf("Ara Toplam      : %.2f TL\n", subtotal);
        System.out.printf("Kupon İndirimi  : -%.2f TL\n", discount);
        System.out.printf("Teslimat Ücreti : %.2f TL\n", DELIVERY_FEE);
        System.out.printf("ÖDENECEK TOPLAM : %.2f TL\n", total);
        System.out.println("==========================================\n");
    }

    public static int getCompletedOrders() {
        return completedOrders;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
