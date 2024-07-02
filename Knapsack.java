package guvidsa;
import java.util.*;
public class Knapsack {

	public static int knapsack(int[] weights, int[] values, int capacity) {
		int n=weights.length;
		
		int[][] dp=new int[n+1][capacity+1];
		
//		build the array
		for(int i=1;i<=n;i++) {
			for(int w=0;w<=capacity;w++) {
				if(weights[i-1]<=w) {
					 dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
				}
				else {
					dp[i][w]=dp[i-1][w];
					
				}
			}
		}
		
		return dp[n][capacity];
				
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights= {2,3,4,5};
		int[] values= {1,2,5,6};
		int capacity=8;
		
		int maxvalues = knapsack(weights, values, capacity);
		System.out.println("Maximum profit using kanpsack =" +maxvalues);

	}

}
