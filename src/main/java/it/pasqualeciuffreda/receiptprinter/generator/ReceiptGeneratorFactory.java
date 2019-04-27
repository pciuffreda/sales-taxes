package it.pasqualeciuffreda.receiptprinter.generator;

import it.pasqualeciuffreda.receiptprinter.service.CalculatorServiceImpl;
import it.pasqualeciuffreda.receiptprinter.service.InitServiceImpl;
import it.pasqualeciuffreda.receiptprinter.service.PrintServiceImpl;

/***
 * 
 * @author pasqualeciuffreda
 * 
 * factory class instanciating ReceiptGenerator objects and resolving dependencies
 * 
 * This class decouple the client from the implementation details so that we can change
 * the implementation details with no change for the invoking client.
 *
 */
public class ReceiptGeneratorFactory {
	
	public static ReceiptGenerator createReceiptGenerator() {
		ReceiptGenerator receiptGenerator = new ReceiptGenerator();
		
		receiptGenerator.setInitService(new InitServiceImpl());
		
		//Dependencies resolutions through setter injection
		receiptGenerator.setCalculatorService(new CalculatorServiceImpl());
		
		receiptGenerator.setPrintService(new PrintServiceImpl());
		
		return receiptGenerator;
	}
}
