package guvidsa;
import java.util.*;


public class JobSequencing {
  static class Job{
	  char id;
	  int deadline;
	  int profit;
	  
	  public Job(char id, int deadline, int profit) {
		  this.id=id;
		  this.deadline=deadline;
		  this.profit=profit;
		  
	  }
  }
  
  public static void jobSequencing(Job[] jobs, int n) {
	  Arrays.sort(jobs, new Comparator<Job>() {
		  public int compare(Job a, Job b) {
			  return b.profit-a.profit;
		  }
	});
	  
	  
	  char[] result = new char[n];
	  boolean[] slot=new boolean[n];
	  
	  
	  for(int i=0;i<n;i++) {
		  slot[i]=false;
	  }
	  
	  for(int i=0; i<jobs.length;i++) {
		  for(int j=Math.min(n-1, jobs[i].deadline-1);j>=0;j--) {
			  if(slot[j]==false) {
				  result[j]=jobs[i].id;
				  slot[j]=true;
				  break;
			  }
		  }
	  }
	  
	  
	  System.out.println("Job Sequence");
	  
	  for(int i=0;i<n;i++) {
		  if(slot[i]) {
			  System.out.println(result[i]+" ");
		  }
	  }
	  
	  
  }
  
  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Job[] jobs= {
				new Job('a',2,20),
				new Job('b',2,15),
				new Job('c',1,10),
				new Job('d',3,5),
				new Job('e',3,1)
				
		};
		
        // Number of jobs
        int n = jobs.length;

        // Function call
        jobSequencing(jobs, n);

		
	}

}
