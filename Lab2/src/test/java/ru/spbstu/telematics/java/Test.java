package ru.spbstu.telematics.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		MyQueue<Integer> int_q = new MyQueue<Integer>(10);
		for(int i = 0; i<11;i++) {
			int_q.insert(i);
		}
	}

}

