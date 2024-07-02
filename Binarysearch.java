package guvidsa;

public class Binarysearch {

	public static int binarysearch(int[] array,int target) {
		int left=0;  //low
		int right=array.length-1; //high
		
		while(left<=right) {
			int mid=left+(right-left)/2;
			
			if(array[mid]==target) {
				return mid;
			}
			
			if(array[mid]<target) {
				left=mid+1;
			}
			else {
				right=mid-1;
				
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array= {2,3,45,55,67,89,90,100};
		int target=189;
		int index = binarysearch(array, target);
		if(index==-1) {
			System.out.println("Target element is not found "+target);
			
		}
		else {
			System.out.println("Target element is found "+target);
		}

	}

}
