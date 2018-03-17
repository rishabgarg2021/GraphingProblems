import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int v; // no. of vertices
	private LinkedList<Integer> adj[]; // stores the adjacent vertices for a given vertex
	private int indegree[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
		indegree = new int[v];
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		indegree[v]++;
	}

	private void AllTopologicalPathRec(ArrayList<Integer> res, boolean[] visited) {
		
		//to indicate if all topological are found
		boolean flag = false;
		//kahn algorithm is being backtracked.
		//to check if any vertex with in-degree 0 is found is not visited 
		//choose that vertex and decrease the in-degree of its adjacent vertices.
		// mark that parent as true and add it to the result array.
		//do this until u traverse all the vertices.
		//once every vertex is visited with one-degree 0(consedring if u decrease indegree of each adjacent vertex).
		//print the stored path.
		//then unvisit the last inserted vertex and increase the in-degree of adjacent and then check if any further adjacent 
		//vertices greater than the vertex which is unvisited with indegree 0 is found. visit that and then again start finding the 
		//vertex and traverse 'em.
		//once every vertex is visited again print them.
	
		for(int i=0;i<v;i++) {
			
			if(indegree[i]==0 && !visited[i]) {
				
				for(Integer j : adj[i]) {
					indegree[j]--;
				}
				visited[i]=true;
				res.add(i);
				AllTopologicalPathRec(res, visited);
				visited[i]=false;
				res.remove(res.size()-1);
				for(Integer k :adj[i]) {
					indegree[k]++;
				}
				flag=true;
				
				
				
				
			}
			
			
		}
		if(!flag) {
			for(int i=0;i<res.size();i++) {
				System.out.print(res.get(i)+" ");
			}
			System.out.println();
		}

	}

	public void allTopoPath() {
		boolean visited[] = new boolean[v];
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			visited[i] = false;
		}
		AllTopologicalPathRec(res, visited);

	}
	public static void main(String [] args) {
		 Graph g = new Graph(6);
		    g.addEdge(5, 2);
		    g.addEdge(5, 0);
		    g.addEdge(4, 0);
		    g.addEdge(4, 1);
		    g.addEdge(2, 3);
		    g.addEdge(3, 1);
		    g.allTopoPath();
		 
	}

}
