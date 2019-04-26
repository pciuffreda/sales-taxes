package it.pasqualeciuffreda.receiptprinter.generator;

import java.util.List;

import it.pasqualeciuffreda.receiptprinter.model.Item;
import it.pasqualeciuffreda.receiptprinter.model.Receipt;
import it.pasqualeciuffreda.receiptprinter.service.CalculatorService;
import it.pasqualeciuffreda.receiptprinter.service.InitService;
import it.pasqualeciuffreda.receiptprinter.service.PrintService;

public class ReceiptGenerator {
	
	private CalculatorService calculatorService;
	
	private PrintService printService;
	
	private InitService initService;
	
	public void setInitService(InitService initService) {
		this.initService = initService;
	}

	public void setPrintService(PrintService printService) {
		this.printService = printService;
	}
	
	public void setCalculatorService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	public List<List<Item>> initDataSource() {
		
		return initService.initDataSource();
	}
	
	public PrintService printReceipt(Receipt receipt) {
		
		printService.printReceipt(receipt);
		
		return printService;
	}

	public Receipt calculate(List<Item> items) {
		
		return calculatorService.calculateTaxesAndTotal(items);
		
	}

}
