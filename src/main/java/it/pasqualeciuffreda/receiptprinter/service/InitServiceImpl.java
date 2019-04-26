package it.pasqualeciuffreda.receiptprinter.service;

import java.util.ArrayList;
import java.util.List;

import it.pasqualeciuffreda.receiptprinter.model.Item;
import it.pasqualeciuffreda.receiptprinter.parser.InputParser;

public class InitServiceImpl implements InitService {
	
	InputParser parser;
	
	public InputParser getParser() {
		if(parser == null) {
			parser = new InputParser();
		}
		return parser;
	}

	@Override
	public List<List<Item>> initDataSource() {
		List<List<Item>> result = new ArrayList<List<Item>>();
		result.add(getParser().parse("input1.csv"));
		result.add(getParser().parse("input2.csv"));
		result.add(getParser().parse("input3.csv"));
		return result;
	}

}
