package action.chap5;

import java.util.stream.Stream;

public class NumberStream {

	public static void main(String[] args) {
		
		Stream.generate(Math::random)
			.forEach(System.out::println);
		

	}

}
