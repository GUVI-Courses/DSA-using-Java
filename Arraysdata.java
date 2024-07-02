package guvidsa;
import java.util.*;


public class Arraysdata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = new int[10];
//		System.out.println(numbers.length);
		
		for(int i =0; i<10; i++) {
			numbers[i]=i+10;
		}
		
//		for(int i =0; i<10; i++) {
//			System.out.println(numbers[i]);
//		}
		
		numbers[3]=300;
		System.out.println(numbers[3]);
//		numbers[11]=400;
		
		int[] num= {10,20,30,40,50};
//		for(int x=0; x<num.length;x++)
//			System.out.println(num[x]);
		
//		for(int i:num)
//			System.out.println(i);
		
		
		System.out.println("Printing using for loop in reverse order");
        for(int i=num.length -1;i>=0;i--){
            System.out.println(num[i]);
        }
		
		
		

	}

}
