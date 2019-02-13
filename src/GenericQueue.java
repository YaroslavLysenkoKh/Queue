import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;

public class GenericQueue<E> extends AbstractQueue<E> {
	private E[] array;
	private final int size;
	private int startQueue;
	private int endQueue;
	private int counter;

	public GenericQueue(int size) {
		this.size = size;
		this.startQueue = 0;
		this.endQueue = 0;
		array = (E[]) new Object[size];
	}

	@Override
	public boolean offer(E e) {
		if ((endQueue == startQueue) && (counter == size)) {
			return false;
		}
		if (startQueue == size) {
			startQueue = 0;
		}
		if (endQueue == size) {
			endQueue = startQueue - 1;
			array[endQueue++] = e;
			counter++;
			startQueue--;
			return true;
		}
		array[endQueue++] = e;
		counter++;
		return true;
	}

	@Override
	public E poll() {
		if (startQueue == size) {
			startQueue = 0;
		}
		E result = array[startQueue];
		array[startQueue++] = null;
		counter--;
		return result;
	}

	@Override
	public E peek() {
		return array[startQueue];
	}

	@Override
	public Iterator<E> iterator() {
		return new GenericQueueIteratorImpl();
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	private class GenericQueueIteratorImpl implements Iterator<E> {
		private int index = startQueue;

		@Override
		public boolean hasNext() {
			return index != array.length;
		}

		@Override
		public E next() {
			int tmp = index;
			index = tmp + 1;
			return array[tmp];
		}

	}

}
