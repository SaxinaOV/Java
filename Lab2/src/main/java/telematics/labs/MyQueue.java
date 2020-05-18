package telematics.labs;

import java.util.Iterator;


public class MyQueue<T> implements IMyQueue<T>, Iterable<T>{
	T[] queue;
	private int max_size;
	private int nElement;

	//@SuppressWarnings("unchecked")
	public MyQueue(int size) {
		max_size = size;
		queue = (T[]) new Object[max_size];
		nElement = 0;
	}

	public void insert(T obj) {
		if (nElement < max_size) {
			queue[nElement] = obj;
			nElement++;
		} else {
			max_size += nElement;
			T[] tmp = (T[]) new Object[max_size];
			for (int i = 0; i < queue.length; i++) {
				tmp[i] = queue[i];
			}
			queue = tmp;
			this.insert(obj);
		}
	}

	public int size() {
		return nElement;
	}

	public T remove() {
		T a = queue[0];
		queue[nElement-1] = null;
		for (int i = 0; i < nElement-1; i++) {
			queue[i] = queue[i+1];
		}
		nElement--;
		return a;
	}

	public void print() {
		for (int i = 0; i < nElement; i++) {
		System.out.println(queue[i]);
		}
	}
	
	public class MyIterator implements Iterator<T>{
			
		private int len = nElement;
		private int index = 0;

		public boolean hasNext() {
			return (index < len);
		}
		public T next() {
			return queue[index++];
		}

	}

	public Iterator<T> iterator() {
        return new MyIterator();
    }
}