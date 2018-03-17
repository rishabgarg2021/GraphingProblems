package checkPathKgreater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	private LinkedList<Node> adj[];
	private int v;
	//helps the determ
	public Graph(int v) {
		// TODO Auto-generated constructor stu
		this.v = v;

		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();

		}
	}

	public void addEdge(int u, int v, int w) {

		adj[u].add(new Node(v, w));
		adj[v].add(new Node(u, w));

	}

	public void allPath(int s, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		res.add(s);
		// System.out.println("here");
		allPathUtil(s, k, res, visited);
	}

	private void allPathUtil(int s, int k, ArrayList<Integer> res, boolean[] visited) {
		visited[s] = true;

		if (k <= 0) {
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i) + "  ");

			}

			System.out.println();

		}
		for (Node n : adj[s]) {

			if (!visited[n.v]) {
				res.add(n.v);

				allPathUtil(n.v, k - n.weight, res, visited);
			
				

			}
		}
		visited[s] = false;
		res.remove(Integer.valueOf(s));

	}

	public static void main(String[] args) {
		int V = 9;
		Graph g = new Graph(V);

		// making above shown graph
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);
		g.allPath(0, 60);
	}

}
