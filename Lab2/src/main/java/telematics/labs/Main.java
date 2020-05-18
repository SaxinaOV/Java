package telematics.labs;

import java.io.IOException;
import java.util.Iterator;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		MyQueue<Integer> m_q = new MyQueue<Integer>(5);
		for(int i = 0; i<5;i++) {
			m_q.insert(i);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i<5;i++) {
			q.add(i);
		}
		System.out.println(q.remove());
		System.out.println(m_q.remove());  
		/*MyQueue<Integer> q = new MyQueue<Integer>(10);
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.remove();
		Iterator<Integer> it = q.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}*/
	}
}
