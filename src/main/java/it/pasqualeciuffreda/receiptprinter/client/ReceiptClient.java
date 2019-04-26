package it.pasqualeciuffreda.receiptprinter.client;

import java.util.List;

import it.pasqualeciuffreda.receiptprinter.generator.ReceiptGenerator;
import it.pasqualeciuffreda.receiptprinter.generator.ReceiptGeneratorFactory;
import it.pasqualeciuffreda.receiptprinter.model.Item;
import it.pasqualeciuffreda.receiptprinter.model.Receipt;

public class ReceiptClient {
	
	public static void main(String[] args) {
		ReceiptGenerator receiptGeneratorFactory = ReceiptGeneratorFactory.createReceiptGenerator();
		
		List<List<Item>> items = receiptGeneratorFactory.initDataSource();
		
		for (List<Item> itemSet : items) {
			Receipt receipt = receiptGeneratorFactory.calculate(itemSet);
			
			receiptGeneratorFactory.printReceipt(receipt);
		}
	}
}
