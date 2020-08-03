package com.twu.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String nm, String address, List<LineItem> lineItems) {
        this.customerName = nm;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : lineItems) {
            totalAmount += lineItem.totalAmount();
        }
        totalAmount += getTotalSalesTax();
        return totalAmount;
    }

    public double getTotalSalesTax() {
        double totalTax = 0d;
        for (LineItem lineItem : lineItems) {
            totalTax += lineItem.getSalesTax();
        }
        return totalTax;
    }

}
