package guvidsa;
import java.util.*;


public class Arraylistss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a1=new ArrayList<>();
		ArrayList<Integer> a2=new ArrayList<>();
		for(int i=1;i<=10;i++)
			a1.add(i);
		
		a1.add(78);
		a1.add(5, 50);//O(n)
		a1.add(120);
//		for(int a:a1)
//			System.out.println(a);
//		
		a1.remove(5);  //O(n) [0,1,2,3,4,...11] =[12]
//		for(int a:a1)
//			System.out.println(a);
		
		System.out.println(a1.contains(9));
		System.out.println(a1.equals(a1));
		System.out.println(a1.equals(a2));
		System.out.println(a1.size());
		System.out.println(a1.get(11));
		System.out.println(a2.isEmpty());
//		System.out.println(a1.toString());

		
		a2.addAll(a1);
//		System.out.println(a1);
		for(int a:a2)
			System.out.println(a);
	}

}
