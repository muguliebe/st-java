package functional.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Compare {
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
	    		.min(Person::ageDifference)
	    		.ifPresent(youngest -> System.out.println("Youngest:" + youngest));
	    }
	  }
}