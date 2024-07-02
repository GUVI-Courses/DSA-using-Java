package guvidsa;
import java.util.*;


public class BFS {

	private int vertices;
	private LinkedList<Integer> adjList[];
	
	BFS(int v){
		vertices=v;
		adjList=new LinkedList[v];
		
		for(int i=0;i<v;++i) {
			adjList[i]= new LinkedList<>();
		}
	}
	
	void addEdge(int v, int w) {
		adjList[v].add(w);
	}
	
	void BFStraversal(int s) {
		boolean visited[] = new boolean[vertices];
		LinkedList<Integer> queue=new LinkedList<>();
		visited[s]=true;
		queue.add(s);
		
		while(queue.size()!=0) {
			s=queue.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> i= adjList[s].listIterator();
			while(i.hasNext()) {
				int n=i.next();
				if(!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BFS g= new BFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		System.out.println("BFS traversal starting form vertex 2: ");
		g.BFStraversal(1);
		
	}

}
