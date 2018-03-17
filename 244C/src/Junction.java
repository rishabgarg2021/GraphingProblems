import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Junction {

	private int v;
	private LinkedList<Integer> adj[];
	private LinkedList<Integer> rev[];

	public Junction(int v) {
		this.v = v;
		adj = new LinkedList[v];
		rev=new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
			rev[i]=new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		rev[v].add(u);
		
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int V = Integer.parseInt(sc.nextLine());
		Junction g = new Junction(V);
		long weights[] = new long[V];
		for(int i=0;i<V;i++) {
			weights[i]=sc.nextLong();
		}
		sc.nextLine();
		int edges = Integer.parseInt(sc.nextLine());
		for(int j=0;j<edges;j++) {
			g.addEdge(sc.nextInt()-1, sc.nextInt()-1);
			sc.nextLine();
		}
		boolean[] visited = new boolean[V];
		Arrays.fill(visited,false);
		Stack<Integer> stack = new Stack();
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				g.topSort(i,visited,stack);
			}
		}
		
		boolean[] revisited = new boolean[V];
		Arrays.fill(revisited,false);
		long minWeight=0;
		long different=1;
		long indifferent=0;
		while(!stack.empty()) {
			
			ArrayList<Integer> res = new ArrayList<>();
			int poppedVertex= stack.get(stack.size()-1);
			
			if(!revisited[poppedVertex]) {
				
					g.dfs(res,poppedVertex,revisited,stack);
				
				long min =weights[res.get(0)]; ;
				
				for(int j=0;j<res.size();j++) {
					if(weights[res.get(j)]==min) {
						indifferent++;
						
						
						
					}
					else if(weights[res.get(j)]<min) {
						min=weights[res.get(j)];
						indifferent=1;
					}
				}
				minWeight+=min;
			
				
				
				
				different=((different%1000000007) * (indifferent%1000000007) )%1000000007 ;;
				indifferent=0;
				res.clear();
			}
			
			
			
			
			
			
			
			
		}
		System.out.println(minWeight +" "+different);
		
		
		
		
	}

	private void dfs(ArrayList<Integer> res, int poppedVertex, boolean[] revisited,Stack stack) {
		revisited[poppedVertex]=true;
		stack.pop();
		
		res.add(poppedVertex);
		for(int j :rev[poppedVertex]) {
			if(!revisited[j]) {
				dfs(res,j, revisited,stack);
			}
			
			
		}
		
	}

	private  void topSort(int vertex,boolean[] visited, Stack stack) {
		visited[vertex]=true;
		for(int j :adj[vertex]) {
			if(!visited[j]) {
				topSort(j, visited, stack);
			}
			
		}
		stack.push(vertex);
		
		
	}
	
	

}
