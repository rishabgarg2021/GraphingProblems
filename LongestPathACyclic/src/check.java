
public class check {
	public static void main(String args[]) {
		LongestPath g = new LongestPath(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);
		// g.newDFS(3);
		// g.TopologicalSort();
		g.TopologicalSortLongestPath(1);
	}
}
