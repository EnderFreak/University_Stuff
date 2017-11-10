import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class PrepareProduction implements Runnable {
	private final List<String> queue;

	PrepareProduction(List<String> q) {
		queue = q;
	}

	public void run() {
		queue.add("1");
		queue.add("done");
	}
}

class DoProduction implements Runnable {
	private final List<String> queue;

	DoProduction(List<String> q) {
		queue = q;
	}

	public void run() {
		String value = queue.remove(0);
		while (!value.equals("*")) {
			System.out.println(value);
			value = queue.remove(0);
		}
	}
}

public class Testing {
	public static void main(String[] args) throws Exception {
		List q = Collections.synchronizedList(new LinkedList<String>());
		Thread p1 = new Thread(new PrepareProduction(q));
		Thread c1 = new Thread(new DoProduction(q));
		p1.start();
		c1.start();
		p1.join();
		c1.join();
	}
}