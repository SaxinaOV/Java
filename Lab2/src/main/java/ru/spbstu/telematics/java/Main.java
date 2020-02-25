
import java.io.IOException;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		MyQueue<Integer> q = new MyQueue<Integer>(10);
		q.insert(5);
		q.insert(6);
		q.insert(7);
		q.remove();
		Iterator<Integer> it = q.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		q.print();
	}
}