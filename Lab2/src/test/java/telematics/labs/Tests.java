package telematics.labs;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class Tests {

	@Test
	public void iteratorTest() {
		MyQueue<Integer> q = new MyQueue<Integer>(11);
		for(int i = 0; i<11;i++) {
			q.insert(i);
		}
		Iterator<Integer> it = q.iterator();
		Integer i = 0;
		while(it.hasNext()){
			assertEquals(it.next(), i); 
			i++;
		}       
	}

	@Test
	public void standartQueueTest() {
		MyQueue<Integer> m_q = new MyQueue<Integer>(11);
		for(int i = 0; i<5;i++) {
			m_q.insert(i);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i<5;i++) {
			q.add(i);
		}
		for(int i = 0; i<5;i++){
			assertEquals(q.remove(), m_q.remove()); 
		}
	}
}
