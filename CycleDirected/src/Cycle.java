import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

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

	public void addEdge(int v, int w) {
		adj[v].add(w);

	}

	public boolean dfsCycle(int i, boolean[] visited, Set<Integer> grey,Integer[][] child,int[] last,ArrayList<Integer> path) {

		grey.add(i);
		path.add(i);
//		System.out.println(grey);
//		System.out.println("visited    "+ Arrays.toString(visited));
		for (int j : adj[i]) {
			System.out.println(j);
			child[i][1]=j;
			
			if (!visited[j]) {
				
				if (grey.contains(j) ) {
					if(path.size()-1>=2 && (path.get(path.size()-1)) != (path.get(path.size()-3))) {
						last[0]=j;
						//System.out.println("path here "+Arrays.asList(path));
						
						return true;
					}
				}
				if (dfsCycle(j, visited, grey,child,last,path)) {
					return true;
				}

			}

		}
		
		grey.remove(i);
		visited[i] = true;

		return false;
	}

	public boolean detectCycle() {
		boolean visited[] = new boolean[v];
		Integer child [][]= new Integer[v][2];
		int length=0;
		ArrayList<Integer> path=new ArrayList<>();
		ArrayList<Integer> store=new ArrayList<>();
		Set<Integer> grey = new HashSet<Integer>();
		int []last= {Integer.MIN_VALUE};

		for (int i = 0; i < v; i++) {
			child[i][1]=-1;
			visited[i] = false;
		}
		
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (dfsCycle(i, visited, grey,child,last,path)) {
				
					int number=last[0];
				
					store.add(number);

					length++;
					for(int j=0;j<v;j++) {
						
						if(child[number][1]!=last[0]) {
							length++;
							
							store.add(child[number][1]);
							number=child[number][1];
							
						}
					}
					//System.out.println();
					System.out.println(length);
					for(int k=0;k<store.size();k++) {
						System.out.print(store.get(k)+" ");
					}
					
					return true;
				}
			}
		}
		
		return false;

	}
	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		String f = sc.nextLine();
//		String[] first = new String[3];
//		first = f.split("\\s");
//		Cycle g = new Cycle(Integer.parseInt(first[0]+1));
//		int one;
//		int two;
//		while (sc.hasNext()) {
//			String s = sc.nextLine();
//
//			String[] n = new String[2];
//			n = s.split("\\s");
//			one = Integer.parseInt(n[0]);
//			two = Integer.parseInt(n[1]);
//			g.addEdge(one, two);
//			g.addEdge(two,one);
//
//		}
		Cycle g = new Cycle(5);
		 g.addEdge(0, 1);
		 g.addEdge(1, 0);
		 g.addEdge(4, 0);
		 g.addEdge( 0,4);
		 g.addEdge(4, 1);
		 g.addEdge(1, 4);
		 g.addEdge(1, 2);
		 g.addEdge(2, 1);
		 g.addEdge(2, 3);
		 g.addEdge(3, 2);
		if (g.detectCycle()) {
			// System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	

	
}
