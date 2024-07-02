package guvidsa;
import java.util.*;


public class Linearsearch {
	
	public static int linearSearch(int[] array,int target) {
		if(array==null) {
			return -1;
		}
		
		for(int i=0;i<array.length;i++) {
			if(array[i]==target) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array= {3,4,5,10,23,43,12,13};
		int target=102;
		int index=linearSearch(array, target);
		if(index==-1) {
			System.out.println("Target element is not found "+target);
		}
		else {
			System.out.println("Target element is found "+target);
		}

	}

}
