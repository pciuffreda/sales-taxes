package it.pasqualeciuffreda.receiptprinter.model;

import java.math.BigDecimal;

public class Item {
	
	private int quantity;
	private String product;
	private BigDecimal startingPrice;
	private BigDecimal taxedPrice;
	private boolean isImported;
	private boolean isExempt;
	
	public Item(int quantity, String product, BigDecimal price, boolean isImported, boolean isExempt) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.startingPrice = price;
		this.taxedPrice = price;
		this.isImported = isImported;
		this.isExempt = isExempt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(BigDecimal price) {
		this.startingPrice = price;
	}

	public BigDecimal getTaxedPrice() {
		return taxedPrice;
	}

	public void setTaxedPrice(BigDecimal taxedPrice) {
		this.taxedPrice = taxedPrice;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public boolean isExempt() {
		return this.isExempt;
	}

	public void setExempt(boolean isExempt) {
		this.isExempt = isExempt;
	}
	
	@Override
	public String toString() {
		return "Item [quantity=" + quantity + ", product=" + product + ", startingPrice=" + startingPrice
				+ ", taxedPrice=" + taxedPrice + ", isImported=" + isImported + ", isExempt=" + isExempt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isExempt ? 1231 : 1237);
		result = prime * result + (isImported ? 1231 : 1237);
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((startingPrice == null) ? 0 : startingPrice.hashCode());
		result = prime * result + ((taxedPrice == null) ? 0 : taxedPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (isExempt != other.isExempt)
			return false;
		if (isImported != other.isImported)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		if (startingPrice == null) {
			if (other.startingPrice != null)
				return false;
		} else if (!startingPrice.equals(other.startingPrice))
			return false;
		if (taxedPrice == null) {
			if (other.taxedPrice != null)
				return false;
		} else if (!taxedPrice.equals(other.taxedPrice))
			return false;
		return true;
	}
}
