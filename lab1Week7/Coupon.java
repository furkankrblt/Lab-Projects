/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1week7;

/**
 *
 * @author mfkar
 */
public class Coupon {
    private String code;
    private double discountRate;
    private double minSubtotal;

    public Coupon(String code, double discountRate, double minSubtotal) {
        if (discountRate > 0.50 || discountRate < 0) {
            throw new IllegalArgumentException("İndirim oranı en fazla %50 olabilir.");
        }
        this.code = code;
        this.discountRate = discountRate;
        this.minSubtotal = minSubtotal;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getMinSubtotal() {
        return minSubtotal;
    }
}
