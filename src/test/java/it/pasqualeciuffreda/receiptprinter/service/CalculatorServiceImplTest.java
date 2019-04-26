package it.pasqualeciuffreda.receiptprinter.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.pasqualeciuffreda.receiptprinter.model.Item;
import it.pasqualeciuffreda.receiptprinter.model.Receipt;
import it.pasqualeciuffreda.receiptprinter.parser.InputParser;

public class CalculatorServiceImplTest {
	
	InputParser ip;
	CalculatorService calculatorService;
	
	@Before
	public void setUp() {
		ip = new InputParser();
		calculatorService = new CalculatorServiceImpl();
	}
	
	@Test
	public void test_not_imported_not_exempt() {
		//arrange
		String inputFile = "input1.csv";
		List<Item> items = ip.parse(inputFile);
		
		//act
		Receipt receipt = calculatorService.calculateTaxesAndTotal(items);
		
		//assert
		assertEquals(receipt.getItems().get(0).getStartingPrice(), BigDecimal.valueOf(12.49).setScale(2, RoundingMode.HALF_UP));
		assertEquals(receipt.getItems().get(0).getTaxedPrice(), BigDecimal.valueOf(12.49).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(receipt.getItems().get(1).getStartingPrice(), BigDecimal.valueOf(14.99).setScale(2, RoundingMode.HALF_UP));
		assertEquals(receipt.getItems().get(1).getTaxedPrice(), BigDecimal.valueOf(16.49).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(receipt.getItems().get(2).getTaxedPrice(), BigDecimal.valueOf(0.85).setScale(2, RoundingMode.HALF_UP));
		assertEquals(receipt.getItems().get(2).getStartingPrice(), BigDecimal.valueOf(0.85).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(receipt.getTaxes(), BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(receipt.getTotal(), BigDecimal.valueOf(29.83).setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void test_imported_not_exempt() {
		//arrange
		String inputFile = "input2.csv";
		List<Item> items = ip.parse(inputFile);
		
		//act
		Receipt receipt = calculatorService.calculateTaxesAndTotal(items);
		
		//assert
		assertEquals(receipt.getItems().get(0).getStartingPrice(), BigDecimal.valueOf(10.00).setScale(2, RoundingMode.HALF_UP));
		assertEquals(receipt.getItems().get(0).getTaxedPrice(), BigDecimal.valueOf(10.50).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(receipt.getItems().get(1).getStartingPrice(), BigDecimal.valueOf(47.50).setScale(2, RoundingMode.HALF_UP));
		assertEquals(receipt.getItems().get(1).getTaxedPrice(), BigDecimal.valueOf(54.63).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(receipt.getTaxes(), BigDecimal.valueOf(7.63).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(receipt.getTotal(), BigDecimal.valueOf(65.13).setScale(2, RoundingMode.HALF_UP));
	}

}
