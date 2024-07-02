package guvidsa;
import java.util.*;

public class Mergesort {
	
	
	public static void mergesort(int[] arr,int l,int m, int r) {
		  int n1 = m - l + 1;
	        int n2 = r - m;

	        // Create temporary arrays
	        int[] L = new int[n1];
	        int[] R = new int[n2];

	        // Copy data to temporary arrays L[] and R[]
	        for (int i = 0; i < n1; ++i)
	            L[i] = arr[l + i];
	        for (int j = 0; j < n2; ++j)
	            R[j] = arr[m + 1 + j];

	        // Merge the temporary arrays back into arr[l..r]

	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;

	        // Initial index of merged subarray array
	        int k = l;
	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
	                arr[k] = L[i];
	                i++;
	            } else {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }

	        // Copy remaining elements of L[] if any
	        while (i < n1) {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }

	        // Copy remaining elements of R[] if any
	        while (j < n2) {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	
	
	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            mergesort(arr, l, m, r);
        }
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int[] arr = {64, 34, 25, 12, 22, 11, 90};
	        System.out.println("Original Array: " + Arrays.toString(arr));

	        // Call mergeSort function to sort the array
	        mergeSort(arr, 0, arr.length - 1);

	        System.out.println("Sorted Array: " + Arrays.toString(arr));
	}
	
//	O(nlogn()) O(n)

}
