package sample.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Mana {

	public static void main(String[] args) throws Exception{
		List<Integer> integers = Arrays.asList(1,2,3,4,5);
		
		integers.stream()
			.reduce((a,b) -> a+b)
			.ifPresent(System.out::println);
	}
	
}
