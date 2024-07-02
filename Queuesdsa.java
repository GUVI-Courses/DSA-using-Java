package guvidsa;
import java.util.*;

class Queue<T> {
	    private T[] elements;
	    private int front; // Index of the front element
	    private int rear; // Index of the rear element
	    private int size; // Current size of the queue
	    private int capacity; // Maximum capacity of the queue


	    @SuppressWarnings("unchecked")
	    public Queue(int capacity) {
	        this.capacity = capacity;
	        elements = (T[]) new Object[capacity];
	        front = 0;
	        rear = -1;
	        size = 0;
	    }

	    // Method to add an element to the queue
	    public void enqueue(T element) {
	        if (isFull()) {
	            throw new IllegalStateException("Queue is full");
	        }
	        rear = (rear + 1) % capacity; // Circular increment
	        elements[rear] = element;
	        size++;
	    }

	    // Method to remove an element from the queue
	    public T dequeue() {
	        if (isEmpty()) {
	            throw new IllegalStateException("Queue is empty");
	        }
	        T removedElement = elements[front];
	        front = (front + 1) % capacity; // Circular increment
	        size--;
	        return removedElement;
	    }
	    
	 // Method to check if the queue is empty
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    // Method to check if the queue is full
	    public boolean isFull() {
	        return size == capacity;
	    }

	    // Method to get the size of the queue
	    public int size() {
	        return size;
	    }
	    
	    public T peek() {
	        if (isEmpty()) {
	            throw new IllegalStateException("Queue is empty");
	        }
	        return elements[front];
	    }


}

public class Queuesdsa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Queue<Integer> queue = new Queue<>(5);
	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	        System.out.println("Dequeued element: " + queue.dequeue());
	        System.out.println("Dequeued element: " + queue.dequeue());
	        System.out.println("Front element: " + queue.peek());
	        System.out.println("Queue size: " + queue.size());
	        queue.enqueue(40);
	        queue.enqueue(50);
	        queue.enqueue(60);
	        System.out.println("Queue size: " + queue.size());
	        System.out.println("Dequeued element: " + queue.dequeue());
	        System.out.println("Dequeued element: " + queue.dequeue());
	}

}
