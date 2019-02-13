import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
		GenericQueue<String> queue = new GenericQueue<>(5);
		System.out.println(queue.size());
		for (int i = 0; i < queue.size(); i++) {
			queue.offer("Number " + i);
		}
		// ***************************************
		System.out.println(queue);
		queue.poll();
		queue.poll();
		queue.offer("asdas");
		System.out.println(queue);
		// ***************************************
		Iterator<String> it = queue.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
