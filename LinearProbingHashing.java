package guvidsa;
import java.util.*;



public class LinearProbingHashing {
	
	
	
	private int[] hashTable;
	private int tableSize;

	
	public  LinearProbingHashing(int size) {
		tableSize=size;
		hashTable=new int[tableSize];
		Arrays.fill(hashTable,-1);
	}
	
	private int hash(int key) {
		return key%tableSize;
	}
	
	
	public void insert(int key) {
		int hashIndex=hash(key);
		int originalIndex=hashIndex;
		int i=0;
		
		
		while(hashTable[hashIndex]!=-1) {
			hashIndex=(originalIndex+i)%tableSize;
			i++;
			
			if(i==tableSize) {
				System.out.println("Hash table is full cannot insert "+key);
				return;
			}
			
		}
		hashTable[hashIndex]=key;
	}
	
	public boolean search(int key) {
		int hashIndex=hash(key);
		int originalIndex=hashIndex;
		int i=0;
		while(hashTable[hashIndex]!=-1) {			
			
			 if (hashTable[hashIndex] == key) {
	                return true;
	            }
	            hashIndex = (originalIndex + i) % tableSize;
	            i++;
	            if (i == tableSize) {
	                return false; // If we've looped through the whole table
	            }
			
		}
		return false;
	}
	
	public void printHashTable() {
		for(int i=0; i<tableSize;i++) {
			System.out.println("Index "+i+":"+hashTable[i]);
		}
	}
	public void delete(int key) {
	        int hashIndex = hash(key);
	        int originalIndex = hashIndex;
	        int i = 0;

	        // Search for the key using linear probing
	        while (hashTable[hashIndex] != -1) {
	            if (hashTable[hashIndex] == key) {
	                hashTable[hashIndex] = -1; // Mark the slot as empty
	                System.out.println("Key " + key + " deleted.");
	                return;
	            }
	            hashIndex = (originalIndex + i) % tableSize;
	            i++;
	            if (i == tableSize) {
	                System.out.println("Key " + key + " not found.");
	                return;
	            }
	        }
	        System.out.println("Key " + key + " not found.");
	    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinearProbingHashing table=new LinearProbingHashing(10);
		table.insert(5);
		table.insert(15);
		table.insert(25);
		table.insert(6);
		table.insert(66);
		table.insert(2);
		table.insert(12);
		table.insert(22);
		System.out.println("hash table after insert:");
		table.printHashTable();
		
		
		 System.out.println("Searching for key 15: " + (table.search(15) ? "Found" : "Not Found"));
	     System.out.println("Searching for key 50: " + (table.search(500) ? "Found" : "Not Found"));
	     table.delete(15);
	     table.delete(2);

	     table.printHashTable();
		
	}

}
