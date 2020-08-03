package com.twu.refactoring;

public class LineItem {
	private String desc;
	private double price;
	private int quantity;

	public LineItem(String desc, double p, int quantity) {
		super();
		this.desc = desc;
		this.price = p;
		this.quantity = quantity;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

    double getSalesTax() {
		return totalAmount() * 0.10;
	}

    public String lineItemToString() {
		StringBuilder output = new StringBuilder();
		output.append(desc)
				.append("\t")
				.append(price)
				.append("\t")
				.append(quantity)
				.append("\t")
				.append(totalAmount())
				.append("\n");

		return output.toString();
	}
}