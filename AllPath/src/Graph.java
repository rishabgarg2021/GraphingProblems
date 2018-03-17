import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
//prints all the possible paths of the graph.
public class Graph {
	private int v;
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void allPath(int source, int destination) {
		boolean[] visited = new boolean[v];
		ArrayList<Integer> res = new ArrayList<>();
		Arrays.fill(visited, false);
		res.add(source);
		allPathUtil(source, destination, visited, res);

	}

	private void allPathUtil(int s, int d, boolean[] visited, ArrayList<Integer> res) {

		visited[s] = true;
		if (s == d) {
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i) + " ");

			}
			System.out.println();
		}

		for (Integer i : adj[s]) {
			if (!visited[i]) {
				res.add(i);
				allPathUtil(i, d, visited, res);

				//System.out.println(i + "   i	   s    " + s);
			

			}
		}
		//System.out.println("s  " + s);
		visited[s] = false;
		res.remove(Integer.valueOf(s));
	}

	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 4);

		int s = 2;
		int d = 3;
		g.allPath(s, d);

	}
}
