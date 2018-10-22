package lambda.first;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class First {

	public static void main(String[] args) {
		
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		final String str = "w00t";

		str.chars()
			.mapToObj(ch -> Character.valueOf((char)ch))
			.forEach(System.out::println);
		
	}
	
	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
		}

	
	static final Function<String, Predicate<String>> startWithLetter =
			letter -> name -> name.startsWith(letter);
}
