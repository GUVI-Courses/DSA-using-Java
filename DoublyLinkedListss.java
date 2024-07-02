package guvidsa;
import java.util.*;


class Node{
	int data;
	Node prev;
	Node next;
	
	
	public Node(int data) {
		this.data=data;
		this.prev=null;
		this.next=null;
	}
	
	
}


class DoublyLinkedList{
	Node head;
	
	public DoublyLinkedList() {
		this.head=null;
	}
	
	 // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
	
    
    // Method to insert a new node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }
	
 // Method to display the doubly linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
	
    
    public Node search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null; // Node not found
    }
    
    // Method to insert a new node after a given node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }
    
    // Method to delete a node with a given value
    public void delete(int value) {
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with value " + value + " not found");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }
	
	
}



public class DoublyLinkedListss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dll = new DoublyLinkedList();
		 dll.insertAtBeginning(5);
		 dll.insertAtBeginning(15);
		 dll.display();
		 dll.insertAtEnd(25);
		 dll.display();
		 dll.insertAfter(dll.head.next, 30);
		 dll.display();
		 
		 Node nodeToSearch = dll.search(130);
	        if (nodeToSearch != null) {
	            System.out.println("Node found with value " + nodeToSearch.data);
	        } else {
	            System.out.println("Node not found");
	        }
	      
	       dll.delete(25);
	       dll.display();
	}

}
