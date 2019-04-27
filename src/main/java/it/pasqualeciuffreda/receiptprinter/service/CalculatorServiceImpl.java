package it.pasqualeciuffreda.receiptprinter.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import it.pasqualeciuffreda.receiptprinter.model.Item;
import it.pasqualeciuffreda.receiptprinter.model.Receipt;

/***
 * 
 * @author pasqualeciuffreda
 *
 * Service implementing the taxes calculation logic
 *  
 */
public class CalculatorServiceImpl implements CalculatorService {
	
	private static final BigDecimal SALES_TAX_STANDARD = new BigDecimal(0.1).setScale(2, RoundingMode.HALF_UP);
	private static final BigDecimal SALES_TAX_IMPORTED = new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP);

	@Override
	public Receipt calculateTaxesAndTotal(List<Item> items) {
		Receipt receipt = new Receipt(items);
		for (Item item : items) {
			calculateTaxes(item, receipt);
			calculateTotal(item, receipt);
		}
		return receipt;
	}

	private void calculateTotal(Item item, Receipt receipt) {
		receipt.setTotal(receipt.getTotal().add(item.getTaxedPrice()));
	}

	private void calculateTaxes(Item item, Receipt receipt) {
		BigDecimal standardTaxAmount = BigDecimal.ZERO;
		BigDecimal importedTaxAmount = BigDecimal.ZERO;
		if(!item.isExempt()) {
			standardTaxAmount = item.getStartingPrice().multiply(SALES_TAX_STANDARD).setScale(2, RoundingMode.HALF_UP);
			item.setTaxedPrice(item.getTaxedPrice().add(standardTaxAmount));
		}
		if(item.isImported()) {
			importedTaxAmount = item.getStartingPrice().multiply(SALES_TAX_IMPORTED).setScale(2, RoundingMode.HALF_UP);
			item.setTaxedPrice(item.getTaxedPrice().add(importedTaxAmount));
		}
		receipt.setTaxes(receipt.getTaxes().add(importedTaxAmount).add(standardTaxAmount));
	}

}
