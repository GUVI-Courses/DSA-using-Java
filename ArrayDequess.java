package guvidsa;
import java.util.*;
public class ArrayDequess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ArrayDeque<Integer> a = new ArrayDeque<>();
	        a.add(6);
	        a.add(56);
	        a.add(9);
	        a.addFirst(5);
	        a.offerFirst(10);
	        a.offerLast(25);
	        System.out.println(a);
	        System.out.println(a.peekFirst());
	        System.out.println(a.getFirst());
	        System.out.println(a.peekLast());
	        System.out.println(a.getLast());
//	        System.out.println(a);
	        a.pollFirst(); 
	        a.removeFirst(); 
	        System.out.println(a);
	        a.pollLast(); 
	        a.removeLast(); 
	        System.out.println(a);
	}

}
