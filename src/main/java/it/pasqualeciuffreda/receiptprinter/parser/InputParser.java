package it.pasqualeciuffreda.receiptprinter.parser;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import it.pasqualeciuffreda.receiptprinter.model.Item;

public class InputParser {
	public List<Item> parse(String csvFile) {
		List<Item> result = null;
		URL resource = getClass().getClassLoader().getResource(csvFile);
		try (Reader reader = Files.newBufferedReader(Paths.get(resource.getFile()));
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			result = new ArrayList<>();
			for (CSVRecord csvRecord : csvParser) {
				int quantity = Integer.valueOf(csvRecord.get("Quantity"));
				String product = csvRecord.get("Product");
				BigDecimal price = new BigDecimal(csvRecord.get("Price")).setScale(2, RoundingMode.HALF_UP);
				boolean imported = Boolean.valueOf(csvRecord.get("Imported"));
				boolean isExempt = Boolean.valueOf(csvRecord.get("Exempt"));
				result.add(new Item(quantity, product, price, imported, isExempt));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
