package telematics.labs;

import java.io.IOException;
import java.util.Iterator;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		MyQueue<Integer> m_q = new MyQueue<Integer>(11);
		for(int i = 0; i<5;i++) {
			m_q.insert(i);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i<5;i++) {
			q.add(i);
		}
		for(int i = 0; i<5;i++){
			System.out.println(q.remove()); 
			System.out.println(m_q.remove()); 
		}
}}
