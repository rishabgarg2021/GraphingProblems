
public class Control {
	public static void main(String args[]) {
		Graph g = new Graph(5);
		g.addEdge(3, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(4, 1);
		
		//g.newDFS(3);
		//g.TopologicalSort();
		g.biPartite();
	}
	
}
