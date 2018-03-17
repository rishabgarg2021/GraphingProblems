import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DifferentColors {

	private int v;
	private LinkedList<Integer> adj[];

	public DifferentColors(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u-1 ].add(v-1);
		adj[v-1 ].add(u -1);
	}

	private boolean isValid(int filling, int vertex, int[] color) {
		for (int j : adj[vertex]) {
			if (filling == color[j]) {
				return false;
			}
		}
		return true;

	}

	public void fillColor(int m) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean[] visited = new boolean[v];
		int[] colors = new int[v];
		for (int j = 0; j < v; j++) {
			colors[j] = -1;
		}
		int distinct = 1;
		Arrays.fill(visited, false);
		colors[0] = 0;

		if (fillUtilColor(0, res, visited, colors, distinct, m)) {
			printSolution(colors);
		}
		;
	}

	private boolean fillUtilColor(int i, ArrayList<Integer> res, boolean[] visited, int[] colors, int distinct, int m) {

		visited[i] = true;
		res.add(i);

		if (res.size() == v) {
			return true;
		}
		for (int j : adj[i]) {
			for (int k = 0; k < m; k++) {

				if (!visited[j] && isValid(k, j, colors)) {
					System.out.println("vertex "+j+"  color  "+k  +"  source  "+adj[i]+"  parent  "+i);
					colors[j] = k;

					if (fillUtilColor(j, res, visited, colors, distinct + 1, m)) {
					
						return true;
					} else {
						System.out.println("value removed   "+j);
						res.remove(Integer.valueOf(j));
						colors[j] = -1;

						visited[j] = false;
					}

				}
			}

		}
		

		return false;

	}

	void printSolution(int colors[]) {
		System.out.println("Solution Exists: Following" + " are the assigned colors");
		for (int i = 0; i < v; i++)
			System.out.print(" " + colors[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		DifferentColors g = new DifferentColors(10);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(2, 9);
		g.addEdge(1, 10);
		g.addEdge(1, 5);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(6, 5);
		g.addEdge(7, 6);
		g.addEdge(7, 10);
		g.addEdge(9, 6);
		g.addEdge(9, 8);
		g.addEdge(10, 8);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(0, 3);
//		g.addEdge(2, 3);
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
		g.fillColor(3);
	}

}
