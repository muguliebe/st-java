package functional.design.calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YahooFinance {
	
	private static final Logger log = LoggerFactory.getLogger(YahooFinance.class);
	
	public static BigDecimal getPrice(final String ticker) {
		try {
			final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);

			final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			final String data = reader.lines().skip(1).findFirst().get();
			log.debug("data => {}", data);
			final String[] dataItems = data.split(",");
			log.debug("get finane result => " + dataItems[0]);
			return new BigDecimal(dataItems[dataItems.length - 1]);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
