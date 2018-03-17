import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Cycle {

	private int v;
	private LinkedList<Integer> adj[];

	public Cycle(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		Cycle c = new Cycle(v);
		int e = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < e; i++) {
			c.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
			sc.nextLine();

		}

		boolean visited[] = new boolean[v];
		boolean recStack[] = new boolean[v];
		Arrays.fill(recStack, false);
		Arrays.fill(visited, false);
		int currentLength[]= {0};
		Stack<Integer> s = new Stack();
		int [] pos= {-1};
		for(int i=0;i<v;i++) {
			
			
			if (c.dfs(0, visited, k, currentLength, 0, recStack,s,pos)) {
				System.out.println(currentLength[0]);
				for ( i = pos[]; i < s.size(); i++) {
					
	
						System.out.print((s.elementAt(i) +1)+ " ");
					
				}
				break;
			}
			currentLength[0]=0;
		}

	}

	private boolean dfs(int u, boolean[] visited, int k, int[] current, int parent, boolean[] recStack,Stack s,int[]pos) {

		if (!visited[u]) {
			current[0]++;
			visited[u] = true;
			recStack[u] = true;
			s.add(u);
			for (int v : adj[u]) {
				
				if (!visited[v] && dfs(v, recStack, k, current, u, recStack,s,pos)) {
					return true;
				} else if (recStack[v] && v != parent) {
					 pos[0] = s.indexOf(v);
					System.out.println(pos);
					if (s.size()-pos[0] >=k+1   ) {
						return true;
					}
				}
			}
		}
		current[0]--;
		recStack[u] = false;
		s.remove(Integer.valueOf(u));
		return false;

	}
}
