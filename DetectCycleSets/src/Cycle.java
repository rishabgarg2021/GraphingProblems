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
		Arrays.fill(parent, -1);
		for (int i = 0; i < edge.length; i++) {
			int x = find(edge[i].src, parent);
			int y = find(edge[i].dest, parent);
			
			if (x == y) {
				return 1;
			}
			union(x, y, parent);

		}

		return 0;

	}

	private void union(int x, int y, int[] parent) {
		int xset = find(x, parent);
		int yset = find(y, parent);
		parent[xset] = yset;

	}

	private int find(int vertex, int[] parent) {
		int v = parent[vertex];
		if (v == -1) {
			return vertex;
		}
		return find(parent[vertex], parent);

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
