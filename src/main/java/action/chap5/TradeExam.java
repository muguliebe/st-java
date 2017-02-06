package action.chap5;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;

public class TradeExam {

	public static void main(String... args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
		
		// q1. 2011년에 일어난 모든 트랜잭션을 찾아, 오름차순으로 정리
		List<JSONObject> q1 = transactions.stream()
			.filter(t -> t.getYear() == 2011)
			.sorted(comparing(Transaction::getValue))
			.map(t -> new JSONObject(t.toString()))
			.collect(toList())
			;
		q1.stream().forEach(json -> System.out.println(json.toString(4) + "\n"));
		
		// q2. 모든 거래자의 도시를 중복없이 나열
		List<String> q2 = transactions.stream()
			.map(t -> t.getTrader().getCity())
			.distinct()
			.collect(toList());
		q2.stream().forEach(System.out::println);
		System.out.println();
		
		// q3.케임브리지에서 근무하는 모든거래자 -> 이름순 나열
		List<Trader> q3 = transactions.stream()
			.map(t -> t.getTrader())
			.filter(t -> t.getCity().equals("Cambridge"))
			.sorted(comparing(Trader::getName))
			.collect(toList())
			;
		q3.stream().forEach(System.out::println);
		
		// q5.밀라노에 거래자가 있는가?
		boolean isMilan = transactions.stream()
					.anyMatch( t -> t.getTrader().getCity().equals("Milan") )
					;
		System.out.println("isMilan:" + isMilan);
		
		// q6. 케임브리지 거주자의 모든 트랜잭션값 출력
		List<Integer> q6 = transactions.stream()
			.filter(t -> t.getTrader().getCity().equals("Cambridge"))
			.map(t -> t.getValue())
			.collect(toList())
			;
		System.out.println(q6);
		
		// q7. 최대 트랜잭션값?
		Optional<Integer> max = transactions.stream()
			.map(Transaction::getValue)
			.reduce(Integer::max)
			;
		max.ifPresent(System.out::println);
		
		
		
		
	}

}
