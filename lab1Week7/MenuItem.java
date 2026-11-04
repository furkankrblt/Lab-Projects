/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week7;

/**
 *
 * @author mfkar
 */
public class MenuItem {

    private String name;
    private double price;
    private int quantity;

    public MenuItem(String name, double price, int quantity) throws InvalidQuantityException {
        if (price <= 0) {
            throw new IllegalArgumentException("Fiyat pozitif olmalıdır.");
        }
        this.name = name;
        this.price = price;
        setQuantity(quantity);
    }

    public MenuItem(MenuItem other) {
        this.name = other.name;
        this.price = other.price;
        this.quantity = other.quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Fiyat pozitif olmalıdır.");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Geçersiz adet: " + quantity);
        }
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return name + " x" + quantity + " - " + price + " TL (Toplam: " + getTotalPrice() + " TL)";
    }
}
