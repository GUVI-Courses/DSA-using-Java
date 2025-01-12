package guvidsa;
import java.util.*;


	class Bellmanford {
	    // Class to represent a weighted edge
	    class Edge {
	        int src, dest, weight;

	        Edge() {
	            src = dest = weight = 0;
	        }
	    };
	    
	    int V, E;
	    Edge edge[];
	    // Creates a graph with V vertices and E edges
	    Bellmanford(int v, int e) {
	        V = v;
	        E = e;
	        edge = new Edge[e];
	        for (int i = 0; i < e; ++i)
	            edge[i] = new Edge();
	    }
	    
	    
	 // The main function to find shortest distances from src to all other vertices
	    void BellmanFord(int src) {
	        int dist[] = new int[V];

	        // Step 1: Initialize distances from src to all other vertices as INFINITE
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        dist[src] = 0;

	        // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src to any other vertex can have at most |V| - 1 edges
	        for (int i = 1; i < V; ++i) {
	            for (int j = 0; j < E; ++j) {
	                int u = edge[j].src;
	                int v = edge[j].dest;
	                int weight = edge[j].weight;
	                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
	                    dist[v] = dist[u] + weight;
	            }
	        }

	        // Step 3: Check for negative-weight cycles. The above step guarantees shortest distances if the graph doesn't contain negative weight cycles. If we get a shorter path, then there is a cycle.
	        for (int j = 0; j < E; ++j) {
	            int u = edge[j].src;
	            int v = edge[j].dest;
	            int weight = edge[j].weight;
	            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
	                System.out.println("Graph contains negative weight cycle");
	                return;
	            }
	        }

	        // Print the calculated distances
	        printArr(dist, V);
	    }

	    // A utility function to print the constructed distance array
	    void printArr(int dist[], int V) {
	        System.out.println("Vertex Distance from Source");
	        for (int i = 0; i < V; ++i)
	            System.out.println(i + "\t\t" + dist[i]);
	    }

	    
	    
	    
	
	    
	    
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int V = 5; // Number of vertices in graph
	     int E = 8; // Number of edges in graph
	     Bellmanford graph = new Bellmanford(V, E);
	     
	     
	  // add edge 0-1 (or A-B)
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	        graph.edge[0].weight = -1;

	        // add edge 0-2 (or A-C)
	        graph.edge[1].src = 0;
	        graph.edge[1].dest = 2;
	        graph.edge[1].weight = 4;

	        // add edge 1-2 (or B-C)
	        graph.edge[2].src = 1;
	        graph.edge[2].dest = 2;
	        graph.edge[2].weight = 3;

	        // add edge 1-3 (or B-D)
	        graph.edge[3].src = 1;
	        graph.edge[3].dest = 3;
	        graph.edge[3].weight = 2;

	        // add edge 1-4 (or A-E)
	        graph.edge[4].src = 1;
	        graph.edge[4].dest = 4;
	        graph.edge[4].weight = 2;

	        // add edge 3-2 (or D-C)
	        graph.edge[5].src = 3;
	        graph.edge[5].dest = 2;
	        graph.edge[5].weight = 5;

	        // add edge 3-1 (or D-B)
	        graph.edge[6].src = 3;
	        graph.edge[6].dest = 1;
	        graph.edge[6].weight = 1;

	        // add edge 4-3 (or E-D)
	        graph.edge[7].src = 4;
	        graph.edge[7].dest = 3;
	        graph.edge[7].weight = -3;

	        graph.BellmanFord(0);
	        
	     
	     
	
	
}
	}
