package guvidsa;

import java.util.Arrays;

public class BubbleSort {
	
	
	public static void bubbleSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
//					swap
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {7,6,4,5,3,2};
		System.out.println("ORiginal array "+Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("Sorted Array using bubble sort "+ Arrays.toString(arr));

	}

}
