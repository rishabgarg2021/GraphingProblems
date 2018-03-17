import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Cycle {
	private int v;
	private LinkedList<Integer> adj[];
	public Cycle(int v) {
		this.v=v;
		adj= new LinkedList[v];
		for ( int i=0;i<v;i++) {
			adj[i]=new LinkedList<Integer>();
			
		}
		
		
	}
	public void addEdge(int u , int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	public boolean detectCycle() {

		
	    boolean visited[]=new boolean[v];
	    boolean recStack[]=new boolean[v];
		Arrays.fill(visited, false);
		Arrays.fill(recStack,false);
		for(int i=0; i<v; i++) {
			if(cycleUtil(i,i,recStack,visited) ) {
				return true;
			}
			
			
		}
		return false;
	    
	}
	private boolean cycleUtil(int u,int parent, boolean[] recStack, boolean[] visited ) {
		if(!visited[u]) {
			
			visited[u]=true;
			recStack[u]=true;
			for(int v : adj[u]) {
				if(!visited[v] && cycleUtil(v,u,recStack,visited)) {
					return true;
				}
				else if(recStack[v] && v!=parent) {
					return true;
				}
			}
			recStack[u]=false;
			return false;
			
			
			
		}
		
		return false;
	}
	public static void main(String [] args) {
		Cycle g = new Cycle(4);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	   g.addEdge(0, 3);

	    g.addEdge(2, 3);

	 
	   if(g.detectCycle()) {
		   System.out.println("cycle");
	   }
	   else {
		   System.out.println("no cycle");
	   }
	   
	}

}
