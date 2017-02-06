package action.chap4;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class DishUsage {
	
	public static void main(String[] args) {

		List<Dish> dishes = Dish.menu;
		dishes.stream()
									.filter(d -> {
										System.out.println("filter " + d.getName());
										return d.getCalories() > 300;
									})
									.map(d -> {
										System.out.println("mapping " + d.getName());
										return d.getName();
									})
									.limit(3)
									.collect(toList())
									;
		
		System.out.println(dishes);
	}
	
}
