package guvidsa;
import java.util.Stack;

public class Stacksss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		create the stack
		
		Stack<String> stack=new Stack<>();
//		push methods
		
		stack.push("Apple");  //O(1)
		stack.push("Orange");
		stack.push("Banana"); 
		stack.push("kiwi"); 
		
		System.out.println("Stack"+stack);
		
//		pop
		
		String popedElement=stack.pop();  //O(1)
		System.out.println("popedElement->"+ popedElement);
		System.out.println("After Pop Stack"+stack);
		
//	peeking the top element
		
		String topelement=stack.peek(); //O(1)
		System.out.println("Top element in stack using peek ->"+topelement); 
		
//	searching
		
		int index=stack.search("Orange"); //O(n)
		if (index!= -1)
				System.out.println("Element is present");
		else
			System.out.println("Element is not present");
		
		System.out.println(stack.size()); //O(1)
		System.out.println(stack.isEmpty()); //O(1)
		
		
	}

}
