import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Shoe {
	private int v;
	private LinkedList<Integer> adj[];
	public Shoe(int v) {
		this.v=v;
		adj=new LinkedList[v+1];
		for(int i=0;i<v+1;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	public  void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  m, total=0;
		int n=sc.nextInt();
		
		Shoe g = new Shoe( n);
		m = sc.nextInt();
		boolean visited[] = new boolean[n+1];
		Arrays.fill(visited, false);
		int indegree[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			indegree[i]=0;
		}
		int i=0;
		while( i!=m) {
			int a= sc.nextInt();
			int b= sc.nextInt();
		
			indegree[a]++;
			indegree[b]++;
			g.addEdge(a, b);
			i++;
			
			
			
		}
		ArrayList<Integer> res = new ArrayList<>();
		
		System.out.println(g.calculateScore(visited,indegree,total,res));
		
		
	}
	private  int calculateScore(boolean[] visited,int[] indegree,int total,ArrayList<Integer> res) {
		boolean flag=true;
		for(int i=1;i<v+1;i++) {
			
			
			if(indegree[i]==1 && !visited[i]) {
				
				res.add(i);
				flag=false;
				visited[i]=true;
			}
		}
		if(!flag) {
			
			total++;
			
			
				
			for(int j :res) {
				for(int k:adj[j]) {
					if(!visited[k]) {
						indegree[k]--;
					}
				}
				
			}
		
			res.clear();
		
			return calculateScore(visited, indegree, total,new ArrayList<Integer>());
		}
				
		else {
			return total;
		}
		
			
			
			
			
			
			
		}
		
	
		
}
