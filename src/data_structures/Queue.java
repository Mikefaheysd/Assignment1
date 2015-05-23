package data_structures;
import java.util.Iterator;
/**
 * The queue class calls methods from LinkedList
 * to perform the actions. The queue has First in
 * first out priority and is used with BreadthFirst search
 * within the queue there are methods to enqueue and dequeue, 
 * empty the queue, check if the queue is empty and search for a specified element.
 */
public class Queue<E> implements Iterable<E> {  
	private LinkedList<E> llist;
	
	public Queue() {
		llist = new LinkedList<E>();
	}
	
	//adds new Object to end of the queue
	public void enqueue(E obj) {
		llist.addLast(obj);
	}
	
	//removes the first Object from the queue
	public E dequeue() {
		return (E) llist.removeFirst();
	}
	
	//returns the size of the queue
	public int size() {
		return llist.size();
	}
	
	//checks to see if the list is empty
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	
	//looks at last element in queue without removing
	public E peek() {
		return (E) llist.peekLast();
	}
	
	//searches to see if there is a specified object in the queue
	public boolean contains(E obj) {
		return llist.contains(obj);
	}
	
	//makes the queue empty
	public void makeEmpty() {
		 llist.makeEmpty();
	}
	
	//iterates through the queue
	public Iterator<E> iterator() {
		return llist.iterator();
	}
}

