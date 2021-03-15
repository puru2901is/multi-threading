package qualys;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyQueue<String> intQueue = new MyQueue<>();
		intQueue.push("Hello");
		intQueue.push("World");
		System.out.println(intQueue.pop()+" "+intQueue.pop());

	}

}
