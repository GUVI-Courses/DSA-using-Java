package guvidsa;
import java.util.*;

public class Quicksort {
	
	public static void quickSort(int [] array) {
		if(array==null || array.length==0) {
			return;
		}
		
		sort(array,0,array.length-1);
	}
	
	public static void sort(int[] array,int low, int high) {
		if(low>=high) {
			return;
		}
		
		int pivot=partition(array,low,high);
		sort(array,low,pivot-1);
		sort(array,pivot+1,high);
	}
	
	

	public static int partition(int[] array,int low, int high) {
		int pivot=array[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(array[j]<pivot) {
				i++;
				swap(array,i,j);
			}
		}
		swap(array,i+1,high);
		return i+1;
	}
	
	private static void swap(int[] array,int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	private static void printArray(int[] array) {
		for(int num:array)
			System.out.println(num+" ");
		System.out.println();
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {12,4,7,8,9,2,6,5};
		System.out.println("Original Array:");
		printArray(array);
		
		quickSort(array);
		System.out.println("Sortted Array:\n");
		printArray(array);
	}

}
