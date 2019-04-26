package it.pasqualeciuffreda.receiptprinter.model;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {
	
	private List<Item> items;
	private BigDecimal taxes = BigDecimal.ZERO;
	private BigDecimal total = BigDecimal.ZERO;
	
	public Receipt(List<Item> items) {
		this.items = items;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public BigDecimal getTaxes() {
		return taxes;
	}
	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((taxes == null) ? 0 : taxes.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Receipt other = (Receipt) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (taxes == null) {
			if (other.taxes != null)
				return false;
		} else if (!taxes.equals(other.taxes))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Receipt [items=" + items + ", taxes=" + taxes + ", total=" + total + "]";
	}

}
