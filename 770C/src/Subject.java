import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Subject {
	private int v;
	private LinkedList<Integer> adj[];

	public Subject(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();

		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();

		Subject g = new Subject(v);
		int c = sc.nextInt();

		int compulsory[] = new int[c];
		for (int i = 0; i < c; i++) {
			compulsory[i] = sc.nextInt()-1;

		}
		
//		 for (int i = 0; i < n; i++) {
//	            int J = sc.nextInt();
//	            for (int j = 0; j < J; j++) {
//	                int next = sc.nextInt();
//	                graph[i].add(next - 1);
//	            }
//	        }
//		
		for (int j = 0; j < v; j++) {
			

			int m = sc.nextInt();

			for (int p = 0; p < m; p++) {
				int z = sc.nextInt();
				
					if(z-1!=j && z!=0) {
						g.addEdge(j, z - 1);
						
					
						
					}
				}
			}
		
		

		boolean[] visited = new boolean[v];
		boolean[] visitedIn = new boolean[v];

		Stack<Integer> q = new Stack<>();
		Arrays.fill(visited, false);
		Arrays.fill(visitedIn, false);
		for (int i = 0; i < compulsory.length; i++) {
			
			if (!visited[compulsory[i]]) {

				if (g.dfs(compulsory[i], visited, q, visitedIn) == -1) {
					System.out.println(-1);
					return;
				} else {
					Arrays.fill(visitedIn, false);
				}
			}

		}
		System.out.println(q.size());
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.elementAt(i) + 1 +" ");
		}

	}

	private int dfs(int i, boolean[] visited, Stack<Integer> q, boolean[] visitedIn) {
		visitedIn[i] = true;
		visited[i] = true;
	
		for (int j : adj[i]) {
			
			if (!visited[j] && dfs(j, visited, q, visitedIn) == 1) {
				
			} else if (visitedIn[j]) {
				return -1;
			}
		}
		
		q.add(i);
	
		visitedIn[i]=false;
		return 1;

	}
}