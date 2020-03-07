package telematics.labs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		MyQueue<Integer> q = new MyQueue<Integer>(11);
		for(int i = 0; i<11;i++) {
			q.insert(i);
		}
        assertEquals(11,q.size());
        
	}

}
