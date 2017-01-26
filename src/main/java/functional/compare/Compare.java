package functional.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class Compare {

	static final Logger log = (Logger) LoggerFactory.getLogger(Compare.class);

	public static void printPeople(
			final String message, final List<Person> people) {

		System.out.println(message);
		people.forEach(System.out::println);
	}



	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Greg", 35));

		Comparator<Person> compareAscending  = (p1, p2) -> p1.ageDifference(p2);
		Comparator<Person> compareDescending = compareAscending.reversed();

		{
			List<Person> listAscendingAge = 
					people.stream()
					.sorted(compareDescending)
					.collect(Collectors.toList())
					;
			//	    	printPeople("test", listAscendingAge);
		}

		{
			people.stream()
			.max(Person::ageDifference)
			.ifPresent(youngest -> log.debug("youngest:" + youngest))
			;
		}
		
		{
			final Function<Person, String> byName = person -> person.getName();
			final Function<Person, Integer> byAge = person -> person.getAge();
			
			log.info("comparing ----");
			people.stream()
				.sorted(Comparator.comparing(byAge).thenComparing(byName))
				.forEach(System.out::println)
				;
		}
		
		{
			List<Person> olderThan20 = new ArrayList<>();
			people.stream()
				.filter(person -> person.getAge() > 20)
				.forEach(person -> olderThan20.add(person));
			System.out.println("older than 20:" + olderThan20);
		}
		
		{
			Map<Integer, List<Person>> peopleByAge =
					people.stream()
						.collect(Collectors.groupingBy(Person::getAge));
			log.info("grouping by:" + peopleByAge);
		}
		
		{  
		    System.out.println("//" + "START:GROUP_BY_AGE_NAME_OUTPUT");
		    Map<Integer, List<String>> nameOfPeopleByAge = 
		      people.stream()
		            .collect(
		              	Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		    System.out.println("People grouped by age: " + nameOfPeopleByAge);
		    System.out.println("//" + "END:GROUP_BY_AGE_NAME_OUTPUT");
		}
		
		{
			Comparator<Person> byAge = Comparator.comparing(Person::getAge);
			Map<Character, Optional<Person>> oldest = 
					people.stream()
						.collect(Collectors.groupingBy(person -> person.getName().charAt(0), 
									Collectors.reducing(BinaryOperator.maxBy(byAge))
								));
			System.out.println(oldest);
		}
	}
}