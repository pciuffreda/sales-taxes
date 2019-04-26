package it.pasqualeciuffreda.receiptprinter.service;

import java.math.BigDecimal;

import it.pasqualeciuffreda.receiptprinter.model.Item;
import it.pasqualeciuffreda.receiptprinter.model.Receipt;

public class PrintServiceImpl implements PrintService {
	
	private String itemFormat = "%1$-40s %2$6.2f %n";
    private String taxFormat = "%1$40s %2$6.2f %n";
    private String totalFormat = "%1$40s %2$6.2f %n%n%n";

    private void purchaseList(Item item) {
        System.out.format(itemFormat, item.getQuantity() + " " + item.getProduct() +": ", item.getTaxedPrice());
    }


    private void salesTax(BigDecimal taxTotal) {
        System.out.format(taxFormat, "Sales Taxes:", taxTotal);
    }

    private void totalSale(BigDecimal saleTotal) {
        System.out.format(totalFormat, "Total:", saleTotal);
    }

    private void lineBreak() {
        String dashes = new String(new char[48]).replace("\0", "-");
        System.out.format(dashes+"%n");
    }
    
	@Override
	public void printReceipt(Receipt receipt) {
		
		for(Item item: receipt.getItems()){
            purchaseList(item);
        }
		
        lineBreak();
        
        salesTax(receipt.getTaxes());
        
        totalSale(receipt.getTotal());

	}

}
