package it.pasqualeciuffreda.receiptprinter.service;

import java.util.List;

import it.pasqualeciuffreda.receiptprinter.model.Item;

/***
 * 
 * @author pasqualeciuffreda
 *
 * Base interface defining the initialization operations
 * 
 */
public interface InitService {
	
	List<List<Item>> initDataSource();

}
