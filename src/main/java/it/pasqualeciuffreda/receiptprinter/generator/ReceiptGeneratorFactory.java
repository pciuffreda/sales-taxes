package it.pasqualeciuffreda.receiptprinter.generator;

import it.pasqualeciuffreda.receiptprinter.service.CalculatorServiceImpl;
import it.pasqualeciuffreda.receiptprinter.service.InitServiceImpl;
import it.pasqualeciuffreda.receiptprinter.service.PrintServiceImpl;

/***
 * 
 * @author pasqualeciuffreda
 * 
 * factory class instanciating Receipt objects and resolve dependencies
 *
 */
public class ReceiptGeneratorFactory {
	
	public static ReceiptGenerator createReceiptGenerator() {
		ReceiptGenerator receiptGenerator = new ReceiptGenerator();
		
		receiptGenerator.setInitService(new InitServiceImpl());
		
		//Dependencies resolutions
		receiptGenerator.setCalculatorService(new CalculatorServiceImpl());
		
		receiptGenerator.setPrintService(new PrintServiceImpl());
		
		return receiptGenerator;
	}

}
