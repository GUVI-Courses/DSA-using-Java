package guvidsa;
import java.util.Arrays;


public class MultiStageGraph {

	static final int INF=Integer.MAX_VALUE;
	
	
	public static int shortestPath(int[][] graph,int stages) {
		int n=graph.length;
		int[] cost=new int[n];
		int[] path=new int[n];
		
		Arrays.fill(cost, INF);
		cost[n-1]=0; 
		
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if(graph[i][j]!=INF && cost[i]>graph[i][j]+cost[j]) {
					cost[i]=graph[i][j]+cost[j];
					path[i]=j;
					
				}
			}
		}
		
		int[] resultPath= new int[stages];
		resultPath[0]=0;
		for(int i=1;i<stages;i++) {
			resultPath[i]=path[resultPath[i-1]];
			
		}
		System.out.println("Shortest Path: ");
		 for (int i = 0; i < stages; i++) {
	            System.out.print(resultPath[i] + " ");
	        }
	        System.out.println();

	        return cost[0];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Example graph as adjacency matrix representation
        int[][] graph = {
            {INF, 1, 2, 5, INF, INF, INF, INF},
            {INF, INF, INF, INF, 4, 11, INF, INF},
            {INF, INF, INF, INF, 9, 5, 16, INF},
            {INF, INF, INF, INF, INF, INF, 2, INF},
            {INF, INF, INF, INF, INF, INF, INF, 18},
            {INF, INF, INF, INF, INF, INF, INF, 13},
            {INF, INF, INF, INF, INF, INF, INF, 2},
            {INF, INF, INF, INF, INF, INF, INF, INF}
        };

        int stages = 4; // Number of stages
        int minCost = shortestPath(graph, stages);
        System.out.println("Minimum cost: " + minCost);
	}

}
