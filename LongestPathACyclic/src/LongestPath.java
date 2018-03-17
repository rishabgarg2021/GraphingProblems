import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class LongestPath {

	private LinkedList<Node> adj[];
	private int v;

	public LongestPath(int v) {
		// TODO Auto-generated constructor stu
		this.v = v;

		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();

		}
	}

	public void addEdge(int u, int v, int w) {

		adj[u].add(new Node(v, w));

	}

	public void tSortUtil(int i, Stack stack, boolean[] visited) {
		visited[i] = true;
		for (Node n : adj[i]) {
			if (!visited[n.v]) {
				tSortUtil(n.v, stack, visited);
			}
		}
		//once the path is fully traversed push it in the stack as there is no chance to visit more vertex from this vertex.\
		
		stack.push(i);

	}

	public void TopologicalSortLongestPath(int s) {
		boolean visited[] = new boolean[v];
		Stack stack = new Stack();
		//it helps to store the distance and parent of given vertices.
		//e.g dit[0][1] will store the parent of vertex 0.
		//dist[0][0] is the acrtual distance on vertex number 0.
		int dist[][] = new int[v][2];
		for (int i = 0; i < v; i++) {
			dist[i][0] = Integer.MIN_VALUE;
			dist[i][1] = -1;
		}
		dist[s][0] = 0;
		dist[s][1] = -1;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				tSortUtil(i, stack, visited);
			}
		}

		while (!stack.empty()) {
			int n = (int) stack.pop();

			for (Node node : adj[n]) {

				if (node.weight + dist[n][0] > dist[node.v][0] && dist[n][0] != Integer.MIN_VALUE) {

					dist[node.v][0] = node.weight + dist[n][0];
					dist[node.v][1] = n;

				}
			}

		}

		//get the maximum distance and find the parent of the vertex and keep on back tracking till the parent 
		//of the given vertex is the source vertex.
		int max = Integer.MIN_VALUE;
		int child = -2;
		for (int i = 0; i < v; i++) {

			if (dist[i][0] > max) {
				max = dist[i][0];
				child = i;
			}
		}
		int i = dist[child][1];

		System.out.println(child);
		while (i != -1) {
			System.out.println(i);
			i = dist[i][1];

		}

	}
}
