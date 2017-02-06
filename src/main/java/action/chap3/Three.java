package action.chap3;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three {

	public static void main(String[] args) {
		
		List<Apple> list = Arrays.asList(
				new Apple(1, "red"    ),
				new Apple(3, "blue"   ),
				new Apple(2, "yellow" ),
				new Apple(5, "black"  ),
				new Apple(4, "white"  )
				);
		
		list.sort(comparing(Apple::getWeight).reversed());
		list.stream()
			.forEach(System.out::println);
		
		
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for(T s : list) {
			if(p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	
	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(){
			
		}
		
		
		public Apple(int weight) {
			super();
			this.weight = weight;
		}


		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}
}
