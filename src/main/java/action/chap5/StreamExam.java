package action.chap5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamExam {

	public static void main(String[] args) {
		String[] arrayOfWords = {"Hello", "World"};
		Stream<String> stream = Arrays.asList(arrayOfWords).stream();
		
		stream.map(word -> word.split(""))
			.flatMap(Arrays::stream)
			.distinct()
			.collect(toList())
			.stream()
			.forEach(System.out::println);
			;
			
		
		Optional<String> ss = stream.findAny();
		ss.ifPresent(System.out::println);
		
	}

}
