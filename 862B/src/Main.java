import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{

	private int v;
	private LinkedList<Integer> adj[];
	boolean[] visited;
	int[] colors ;
	
	public Main(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
		visited = new boolean[v];
	    colors = new int[v];
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
		
		int[] colors = new int[v];
		for (int j = 0; j < v; j++) {
			colors[j] = -1;
		}
		int distinct = 1;
		Arrays.fill(visited, false);
		colors[0] = 0;
	  
			if (fillUtilColor(0, res, distinct, m)) {
				System.out.println("here");
				printSolution(colors);
			}
	    
		;
	}

	private boolean fillUtilColor(int i, ArrayList<Integer> res,  int distinct, int m) {

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

					if (fillUtilColor(j, res,  distinct + 1, m)) {
					
						return true;
					} 
					

				}
			}

		}
		return false;

		

	}
	public boolean exist(LinkedList<Integer>[] adj,int u,int v) {
		for(int x: adj[u]) {
			if(x==v) {
				return false;
			}
		}
		return true;
	}
	void printSolution(int colors[]) {
		int total = 0;
		int verStart = 0;
		int col = colors[0];
		for (int z = 0; z < v; z++) {
			for (int j = z + 1; j < v; j++) {

				if (colors[j] != col && exist(adj,z,j)) {
					System.out.println(z+"   z  "+j);
					total++;
				}

			}
			if(z+1<v) {
				col = colors[z + 1];
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Main g = new Main(n);

		for (int i = 0; i < n - 1; i++) {
			g.addEdge(sc.nextInt(), sc.nextInt());
		}
		g.fillColor(2);
	}

}
