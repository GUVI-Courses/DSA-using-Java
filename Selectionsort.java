package guvidsa;

import java.util.Arrays;

public class Selectionsort {
	
	public static void selectionsort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int minIndex=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			
//			swap
			int temp=arr[minIndex];
			arr[minIndex]=arr[i];
			arr[i]=temp;
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {7,6,4,5,3,2};
		System.out.println("ORiginal array "+Arrays.toString(arr));
		selectionsort(arr);
		System.out.println("Sorted Array using Selection sort "+ Arrays.toString(arr));

	}

}
