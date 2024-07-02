package guvidsa;
import java.util.*;


public class Prims {
	
	private static final int INF=Integer.MAX_VALUE;
	
	public static void primMST(int[][] graph, int V) {
		int[] parent = new int[V]; // Array to store constructed MST
		int[] key =new int[V]; // Key values used to pick minimum weight edge
		boolean[] mstSet=new boolean[V]; // To represent set of vertices included in MST
		
		// Initialize all keys as INFINITE
		Arrays.fill(key, INF);
		// Always include first vertex in MST.
		key[0]=0; // Make key 0 so that this vertex is picked as first vertex
		parent[0]=-1; // First node is always root of MST
		
		// The MST will have V vertices
		
		for(int count=0;count<V-1;count++) {
			// Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet, V);
            
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
            // graph[u][v] is non zero only for adjacent vertices of m
            // mstSet[v] is false for vertices not yet included in MST
            // Update the key only if graph[u][v] is smaller than key[v]
            for (int v = 0; v < V; v++) { 
            if(graph[u][v]!=0 && !mstSet[v] && graph[u][v]<key[v]) {
            	parent[v]=u;
            	key[v]=graph[u][v];
            }
            }
		}
		   // Print the constructed MST
        printMST(parent, graph, V);
		
	}
	
	   private static void printMST(int[] parent, int[][] graph, int V) {
	        System.out.println("Edge \tWeight");
	        for (int i = 1; i < V; i++)
	            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	    }
	
	private static int minKey(int[] key, boolean[] mstSet,int V) {
		  int min = INF, min_index = -1;

	        for (int v = 0; v < V; v++) {
	            if (!mstSet[v] && key[v] < min) {
	                min = key[v];
	                min_index = v;
	            }
	        }

	        return min_index;
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = new int[][]{{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}};

            primMST(graph, 5);
	}

}
