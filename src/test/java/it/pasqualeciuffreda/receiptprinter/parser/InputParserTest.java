package it.pasqualeciuffreda.receiptprinter.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.pasqualeciuffreda.receiptprinter.model.Item;

public class InputParserTest {
	
	InputParser ip = null;
	
	@Before
	public void setUp() {
		ip = new InputParser();
	}
	
	@Test
	public void testParse() {
		//arrange
		String filePath = "input1.csv";
		
		//act
		List<Item> results = ip.parse(filePath); 
		
		//assert
		assertNotNull(results);
		assertEquals(results.size(), 3);
		assertEquals(results.get(0).isImported(), false);
		assertEquals(results.get(0).isExempt(), true);
		
		assertEquals(results.get(1).isImported(), false);
		assertEquals(results.get(1).isExempt(), false);
	}

}
