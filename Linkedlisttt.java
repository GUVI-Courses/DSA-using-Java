//package guvidsa;
//import java.util.*;
//
//
//class Node{
//	int data;
//	Node next;
//	
//	public Node(int data) {
//		this.data=data;
//		this.next=null;
//	}
//}
//
//class LinkedList{
//	Node head;
//	
//	public LinkedList() {
//		this.head=null;
//	}
//	
////	insert at beginning of linked list
//	
//	public void insertAtBeginning(int data) {
//		Node newNode=new Node(data);
//		newNode.next=head;
//		head=newNode;
//	}
//	
////	insertion at the end of linkedlist
//	
//	public void insertAtEnd(int data) {
//		Node newNode=new Node(data);
//		if(head==null) {
//			head=newNode;
//			return;
//					
//		}
//		
//		Node current=head;
//		while(current.next!=null) {
//			current=current.next;
//			
//			
//		}
//		current.next=newNode;
//	}
//	
////	Insertion at the middle of linked list
//	
//	public void insertAtMiddle(int data,int position) {
//		Node newNode=new Node(data);
//		if(position==0 || head==null) {
//			newNode.next=head;
//			head=newNode;
//			return;
//		}
//		
//		Node current=head;
//		for(int i=0;i<position-1 && current.next!=null;i++)
//			current=current.next;
//		
//		if(current==null)
//			throw new IllegalArgumentException("Position is out of bond..");
//		newNode.next=current.next;
//		current.next=newNode;
//	}
//	
//	
////	print all data
//	
//	public void printList() {
//		Node current=head;
//		while(current!=null) {
//			System.out.println(current.data+" ");
//		   current=current.next;
//	 }
//		System.out.println();
//	}
//	
//	
//	
////	Delete Operations
//	 public void deleteFromBeginning() {
//	        if (head == null)
//	            return;
//	        head = head.next;
//	    }
//	
//	 
//	// Deletion from the end of the linked list
//	    public void deleteFromEnd() {
//	        if (head == null || head.next == null) {
//	            head = null;
//	            return;
//	        }
//	        Node current = head;
//	        while (current.next.next != null) {
//	            current = current.next;
//	        }
//	        current.next = null;
//	    }
//	    
//	    
//	    // Deletion from the middle of the linked list
//	    public void deleteFromMiddle(int position) {
//	        if (position == 0 || head == null) {
//	            if (head != null)
//	                head = head.next;
//	            return;
//	        }
//	        Node current = head;
//	        for (int i = 0; i < position - 1 && current.next != null; i++) {
//	            current = current.next;
//	        }
//	        if (current == null || current.next == null)
//	            throw new IllegalArgumentException("Position is out of bounds");
//	        current.next = current.next.next;
//	    }
//
//}
//
//
//
//
//public class Linkedlisttt {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		LinkedList list = new LinkedList();
//		
////		Adding the nodes
//		
//		list.insertAtBeginning(1);
//		list.insertAtEnd(4);
//		list.insertAtMiddle(2, 1);
//		list.insertAtMiddle(3, 2);
//		list.insertAtBeginning(0);
//		list.insertAtEnd(5);
//		
//		
//		list.deleteFromBeginning();
//		list.deleteFromEnd();
//		list.deleteFromMiddle(2);
//		list.printList();
//
//	}
//
//}
