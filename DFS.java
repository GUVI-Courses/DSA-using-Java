package guvidsa;
import java.util.*;

public class DFS {
	 private int vertices; // Number of vertices in the graph
	 private LinkedList<Integer> adjList[]; // Adjacency list
	 

	    // Constructor
	    DFS(int v) {
	        vertices = v;
	        adjList = new LinkedList[v];
	        for (int i = 0; i < v; ++i) {
	            adjList[i] = new LinkedList<>();
	        }
	    }
	    // Method to add an edge into the graph
	    void addEdge(int v, int w) {
	        adjList[v].add(w);
	    }

	    // DFS traversal from a given source node
	    void DFStraversal(int v) {
	        boolean visited[] = new boolean[vertices];
	        DFSUtil(v, visited);
	    }
	    
	    // Recursive method for DFS traversal
	    void DFSUtil(int v, boolean visited[]) {
	        visited[v] = true;
	        System.out.print(v + " ");

	        Iterator<Integer> i = adjList[v].listIterator();
	        while (i.hasNext()) {
	            int n = i.next();
	            if (!visited[n]) {
	                DFSUtil(n, visited);
	            }
	        }
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DFS g = new DFS(4);

	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);

	        System.out.println("Depth First Traversal starting from vertex 2:");

	        g.DFStraversal(1);
	}

}
