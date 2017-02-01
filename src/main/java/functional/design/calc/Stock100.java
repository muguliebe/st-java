package functional.design.calc;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class Stock100 {
	
	public static void main(String[] args) {
		final BigDecimal HUNDRED = new BigDecimal("100"); 
		System.out.println("Stocks priced over $100 are " +
				Tickers.symbols.parallelStream()
//					.filter( symbol -> YahooFinance.getPrice(symbol).compareTo(HUNDRED) > 0 )
					.map( YahooFinance::getPrice)
					.filter( price -> price.compareTo(HUNDRED) > 0)
					.sorted()
					.collect(Collectors.toList())
		);
	}
}
