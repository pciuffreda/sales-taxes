package it.pasqualeciuffreda.receiptprinter.service;

import java.util.List;

import it.pasqualeciuffreda.receiptprinter.model.Item;
import it.pasqualeciuffreda.receiptprinter.model.Receipt;

/***
 * 
 * @author pasqualeciuffreda
 * 
 * Base interface defining the calculation operation
 */

public interface CalculatorService {
	
	Receipt calculateTaxesAndTotal(List<Item> items);


}
