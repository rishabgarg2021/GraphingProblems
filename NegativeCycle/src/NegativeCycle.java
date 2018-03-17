import java.util.ArrayList;
import java.util.LinkedList;

public class NegativeCycle {
	private int v;
	private LinkedList<Node> adj[];

	public NegativeCycle(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();

		}

	}

	public void addEdge(int u, int v, int w) {
		Node n = new Node(v, w);
		adj[u].add(n);

	}

	private int giveWeight(int k, int u) {

		for (Node n : adj[k]) {
			if (n.v == u) {

				return (n.w);
			}
		}
		return 0;
	}

	private boolean negRec(int u, Boolean[] visited, ArrayList<Integer> recStack, Integer[] parent) {
		if (!visited[u]) {
			// makes the vertex visit and its ongoing depth vertices true so
			// that we may check on further traversal that there is chance to revisit the
			// vertex to form a cycle.if we reach the end of all depth from a vertex and
			// couldn't find a vertex remove it from recstack.
			visited[u] = true;
			recStack.add(u);
			for (Node n : adj[u]) {
				// store the parent for each traversal.it may change.
				// e.g 5->2,4->2. depends which comes first and checks if cycle is not there.
				parent[n.v] = u;

				// if vertex is not visited call recursive function and ifits visited
				// then check if its neighbour is in rec stack froming a cycle.
				if (!visited[n.v] && negRec(n.v, visited, recStack, parent)) {
					return true;
				} else if (recStack.contains(n.v)) {
					//cycle is formed.just check if given cycle is negative or not.
					//if it is not negative than consider as if cycle is not formed
					//and try to consider other cycles too which has chancve to form a 
					//negative cycle.
					//n.v is the vertex which is visited once again.
					//need to add weights for a given cycle formed and chewck if its
					//negative or not.
					int total = 0;
					int p = parent[u];
					total += giveWeight(u, n.v);
					while (p != n.v) {

						total += giveWeight(p, u);

						u = p;
						p = parent[p];

					}

					total += giveWeight(n.v, u);

					if (total < 0) {
						System.out.println(total + "total");
						return true;
					}

				}

			}

		}
		recStack.remove(Integer.valueOf(u));
		return false;

	}

	public boolean detectNegativeCycle() {
		Boolean visited[] = new Boolean[v];
		// parent array to store the parent of vertices.e.g: parent[2] stores the parent
		// of vertex 2. 3->2.
		Integer parent[] = new Integer[v];
		// it keeps the track of visited depth from a vertex and removes if
		// that depth is fully traversed for a given vertex as we cannot go anywhere
		// from that removed vertex.
		ArrayList<Integer> recStack = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			visited[i] = false;
			parent[i] = -1;
		}
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (negRec(i, visited, recStack, parent)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		NegativeCycle g = new NegativeCycle(6);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		// g.addEdge(3, 0, -1);
		g.addEdge(1, 4, -1);
		g.addEdge(4, 5, -1);
		g.addEdge(5, 1, 0);

		// g.newDFS(3);
		// g.TopologicalSort();
		System.out.println(g.detectNegativeCycle());
	}

}
