package it.pasqualeciuffreda.receiptprinter.service;

import it.pasqualeciuffreda.receiptprinter.model.Receipt;

/***
 * 
 * @author pasqualeciuffreda
 *
 *	Interface of the printing result service
 */

public interface PrintService {
	
	void printReceipt(Receipt receipt);

}
