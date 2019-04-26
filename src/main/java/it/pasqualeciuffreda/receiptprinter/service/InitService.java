package it.pasqualeciuffreda.receiptprinter.service;

import java.util.List;

import it.pasqualeciuffreda.receiptprinter.model.Item;

public interface InitService {
	
	List<List<Item>> initDataSource();

}
