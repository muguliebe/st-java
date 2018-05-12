package lambda.fi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Greeter {
	
	private static final Logger log = LoggerFactory.getLogger(Greeter.class);
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		Greeting lambda = () -> log.info("wow");
		lambda.perform();
		
		Greeting inner = new Greeting() {
			public void perform() {
				log.info("wow2");
			}
		};
		
		greeter.greet(() -> log.info("greet"));
		greeter.greet(inner);
	}

}
