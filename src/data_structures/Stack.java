package data_structures;
import data_structures.*;
import java.util.Iterator;
/**
 * The stack calls methods from LinkedList class to
 * Perform the necessary conditions. The stack works
 * with last in first out order and is used for
 * depthFirst searches. 
 * within the stack there are methods to push and pop, 
 * empty the stack, check if the stack is empty and search for a specified element.
 * 
 * @author michaelfahey
 *
 * @param <E>
 */
public class Stack<E> implements Iterable<E> {
	private LinkedList<E> llist;
	
	public Stack() {
	llist = new LinkedList<E>();
	}
	
	//Pushes Objects onto the stack
	public void push(E obj)  {
		 llist.addFirst(obj);
	}
	
	//Pops Objects off of the stack with last in first out order
	public E pop() {
		return (E) llist.removeFirst();
	}
	
	//Returns the size of the stack
	public int size() {
		return llist.size();
	}
	
	//checks to see if the stack is empty
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	
	//checks to see if the stack is full
	public boolean isFull() {
		return llist.isFull();
	}
	
	//looks at first Object without removing it
	public E peek() {
		return (E) llist.peekFirst();
	}
	
	//searches the stack to see if it contains a specified Object
	public boolean contains(E obj) {
		return llist.contains(obj);
	}
	
	//makes stack empty
	public void makeEmpty() {
		 llist.makeEmpty();
	}
	
	//iterates through stack
	public Iterator<E> iterator() {
		return llist.iterator();
	}
}

