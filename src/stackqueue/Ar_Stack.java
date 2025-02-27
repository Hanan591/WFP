package stackqueue;


import java.util.ArrayList;

public class Ar_Stack <T> {
	//Use private variables to preserve Encapsulation 
	public static final int MAXSIZE = 100; //Note: we'll enforce this LOGICALLY since the ArrayList has no max size.	
	ArrayList<T> StackItems;
	private int top;

	
	public Ar_Stack() {
		top = -1; //a newly constructed list has 0 elements
		StackItems = new ArrayList<T>();
	}

	boolean isEmpty() {
		return top == -1;
	}
	
	boolean isFull() {
		return top == MAXSIZE -1;
	}

	void push(T newItem) throws Exception {
		if (isFull())
			throw new Exception("Stack overflow exception.");
		top++;
		StackItems.add(newItem);
	}
	
	T pop() throws Exception {
		if (isEmpty())
			throw new Exception("Stack underflow exception.");
		top--;
		return StackItems.removeLast();
	}

	T peek() throws Exception {
		if (isEmpty())
			throw new Exception("Stack underflow exception.");
		return StackItems.getLast();
	}
}
