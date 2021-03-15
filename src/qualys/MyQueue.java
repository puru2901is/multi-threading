package qualys;

public class MyQueue<T> {

	Node<T> head = null, tail = null;
	
	public synchronized void push(T data) {
		Node<T> n = new Node(data);
		if(head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = tail.next;
		}		
	}
	
	public synchronized T pop() {
		Node n = head;
		if( n == null) {
			return null;
		}
		if(head == tail) {
			tail = null;
		}
		
		head = head.next;
		return (T) n.data;
	}
}
