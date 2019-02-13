import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class StringQueue {
	private GenericQueue<String> queue;
	Collator collator = Collator.getInstance(new Locale("uk", "UA"));

	public StringQueue(int size) {
		this.queue = new GenericQueue<>(size);
	}

	public boolean offer(String value) {
		if (value.matches("[A-ZА-ЯЁЇЄІ]{1}")) {
			queue.offer(value);
			return true;
		}
		return false;
	}

	public String poll() {
		return queue.poll();
	}

	public String peek() {
		return queue.peek();
	}

	@Override
	public String toString() {
		List<String> list = new ArrayList<>();
		Iterator<String> it = queue.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		Collections.sort(list, collator);
		return list.toString();
	}
}
