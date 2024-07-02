package guvidsa;

public class Towerofhanoi {
   
	
	public static void towerofhanoi(int n,char source, char destination,char auxilary) {
		
		
		if(n==1) {
			System.out.println("Move disk 1 from "+source+" to "+destination);
			return;
					
		}
//		Move the top n-1 disks from source to auxilary
		towerofhanoi(n-1,source,auxilary,destination);
		System.out.println("Move Disk "+ n+ " from "+source+" to "+destination);
		
		towerofhanoi(n-1,auxilary,destination,source);
		System.out.println("Move Disk "+ n+ " from "+source+" to "+destination);
		

		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numbersofdisks=3;
		towerofhanoi(numbersofdisks, 'A', 'C', 'B');

	}

}
