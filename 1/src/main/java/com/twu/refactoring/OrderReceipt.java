package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {

	public static final String header = "======Printing Orders======\n";
	private Order order;


    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append(header)
				.append(getCustomerInfo())
			  	.append(getLineItemsInfo())
			  	.append(getSalesTax())
				.append(getTotalAmount());

		return output.toString();
	}

	private String getTotalAmount() {
		StringBuilder output = new StringBuilder();
		output.append("Total Amount")
				.append('\t')
				.append(order.getTotalAmount())
				.append("\n");
		return output.toString();
	}

	private String getSalesTax() {
		StringBuilder output = new StringBuilder();
		output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());
		return output.toString();
	}

	private String getCustomerInfo() {
		StringBuilder output = new StringBuilder();
		output.append(order.getCustomerName()).append("\t").append(order.getCustomerAddress());
		return output.toString();
	}

	private String getLineItemsInfo() {
		StringBuilder output = new StringBuilder();
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.lineItemToString());
		}
		return output.toString();
	}
}