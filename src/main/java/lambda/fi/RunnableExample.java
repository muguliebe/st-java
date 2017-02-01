package lambda.fi;

public class RunnableExample {

	public static void main(String[] args) {
		Thread t = new Thread(() -> System.out.println("good"));
		t.run();

	}

}
