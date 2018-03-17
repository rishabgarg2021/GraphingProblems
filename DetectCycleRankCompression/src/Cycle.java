import java.util.Arrays;


public class Cycle {
	private int v;
	Edge edge[];

	public class Edge {
		int src, dest;

	}

	public Cycle(int v, int e) {
		this.v = v;
		edge = new Edge[e];
		for (int i = 0; i < v; i++) {
			edge[i] = new Edge();
		}

	}

	public void addEdge(int number,int u, int v) {
		edge[number].src = u;
		edge[number].dest = v;
	}

	public int isCycle() {
		int parent[] = new int[v];
		int rank[] = new int[v];
		
		for(int i=0;i<v;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		for (int i = 0; i < edge.length; i++) {
			int x = find(edge[i].src, parent);
			int y = find(edge[i].dest, parent);
			
			if (x == y) {
				return 1;
			}
			union(x, y, parent,rank);

		}

		return 0;

	}

	private void union(int x, int y, int[] parent,int[] rank) {
		int xset = find(x, parent);
		int yset = find(y, parent);
		if(rank[xset]>rank[yset]) {
			parent[yset]=xset;
			
		}
		else if(rank[xset]<rank[yset]) {
			parent[xset] = yset;
		}
		else {
			parent[xset]=yset;
			rank[yset]++;
			
		}

	}

	private int find(int vertex, int[] parent) {
		return parent[vertex] =( (parent[vertex]==vertex)? vertex: find(parent[vertex],parent));

	}
	public static 
	void main(String []args) {
		
		Cycle c = new Cycle(3,3);
		c.addEdge(0,0, 1);
		c.addEdge(1,0, 2);
		c.addEdge(2,1, 2);
		
		System.out.println(c.isCycle());
		
		
	}

}
