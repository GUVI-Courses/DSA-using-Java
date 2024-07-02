package guvidsa;
import java.util.Arrays;


public class Heap {

	private int[] heap;
	private int size;
	private boolean isMinHeap;
	
	public Heap(int capacity,boolean isMinHeap) {
		this.heap=new int[capacity];
		this.size=0;
		this.isMinHeap=isMinHeap;
	}
	
	private int parent(int i) { return (i-1)/2;}
	private int leftChild(int i) { return 2*i+1;}
	private int rightChild(int i) { return 2*i+2;}
	
	
	private void swap(int i, int j) {
		int temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
		
	}
	
	
//	heapify-up bottom to top
	private void heapifyUp(int i) {
		if(i==0) return;
		
		int parentIndex=parent(i);
		
		if(isMinHeap) {
			if(heap[i]<heap[parentIndex]) {
				swap(i,parentIndex);
				heapifyUp(parentIndex); //recursively heapify up the parent
			}
		}
		else {
			if(heap[i]>heap[parentIndex]) {
				swap(i,parentIndex);
				heapifyUp(parentIndex);
			}
		}
	}

	
//	method heapify-down Top to bottom 
	private void heapifyDown(int i) {
		int left=leftChild(i);
		int right=rightChild(i);
		int extremum=i;
		
		if(isMinHeap) {
			if(left<size && heap[left]<heap[extremum]) {
				extremum=left;
			}
			if(right<size && heap[right]<heap[extremum]) {
				extremum=right;
			}
		}
		else {
			if(left<size && heap[left]>heap[extremum]) {
				extremum=left;
			}
			if(right<size && heap[right]>heap[extremum]) {
				extremum=right;
			}
		}
		
		if(extremum!=i) {
			swap(i,extremum);
			heapifyDown(extremum);
		}
			
		
	}
	
	
//	Insertion
	
	public void insert(int key) {
		if(size==heap.length) {
			heap=Arrays.copyOf(heap, size*2);
		}
		
		heap[size]=key;
		heapifyUp(size);
		size++;
	}
	
//	delete
	public int delete() {
		if(size==0) throw new IllegalStateException("Heap is empty");
		
		int root=heap[0];
		heap[0]=heap[size-1];
		size--;
		heapifyDown(0);
		return root;
		
	}
	
	
	public void heapSort() {
		int[] originalHeap=Arrays.copyOf(heap, size);
		int originalSize=size;
		
		for(int i=size-1;i>=0;i--) {
			swap(0,i);
			size--;
			heapifyDown(0);
		}
		
		size=originalSize;
		heap=originalHeap;
	}
	
	
	public void printHeap() {
		for(int i=0;i<size;i++) {
			System.out.println(heap[i]+" ");
		}
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Heap minHeap=new Heap(10,true);
		Heap maxHeap=new Heap(10,false);
		
		int[] values= {10,20,15,30,40};
		
		System.out.println("Min Heap");
		
		for(int value:values) {
			minHeap.insert(value);
		}
		
		minHeap.printHeap();
		
		System.out.println("Max-Heap");
		for(int value:values) {
			maxHeap.insert(value);
		}
		maxHeap.printHeap();
//		
//		System.out.println("Deleted from min-heap "+ minHeap.delete());
//		minHeap.printHeap();
//		System.out.println("Deleted from min-heap "+ minHeap.delete());
//		minHeap.printHeap();
//		
//		System.out.println("Deleted from max-heap "+ maxHeap.delete());
//		minHeap.printHeap();
//		System.out.println("Deleted from max-heap "+ maxHeap.delete());
//		minHeap.printHeap();
		
		System.out.println("Heap Sort(Min-Heap");
		minHeap.heapSort();
		minHeap.printHeap();
		
		System.out.println("Heap Sort(Max-Heap");
		maxHeap.heapSort();
		maxHeap.printHeap();
	}

}
