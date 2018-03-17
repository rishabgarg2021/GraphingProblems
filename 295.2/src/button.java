import java.util.LinkedList;
import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class button {

	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private static LinkedList<Integer> adj[];

	// Constructor
	public button(int v) {

		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	public static void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public static void main(String[] args) {
		// System.out.println(Math.log(33)/Math.log(2));

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int upper = n;
		int lower = 1;
		if (n < m) {
			lower = n - (m / 2);
			if (lower > 0) {

			} else {
				lower = 1;
			}

			for (int i = 0; i < m; i++) {
				if (upper <= m) {
					upper = 2 * upper;

				} else {
					break;
				}

			}
		}
	

		button b = new button(upper + 1);
		for (int j = lower; j <= upper; j++) {
			if (j - 1 > 0 && j <= upper) {

				b.addEdge(j, j - 1);

			}
			if ((2 * j) <= upper) {

				b.addEdge(j, j * 2);

			}

		}

		System.out.println(buttonHit(n, m, lower, upper));

	}

	private static int minVertex(int lower, int upper, boolean[] visited, int[] weight) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = lower; i <= upper; i++) {
			if (weight[i] < min && !visited[i]) {
				index = i;
				min = weight[i];

			}

		}
		return index;
	}

	private static int buttonHit(int n, int m, int lower, int upper) {
		int[] weight = new int[upper + 1];
		boolean visited[] = new boolean[upper + 1];
		int parent[] = new int[upper + 1];
		for (int i = lower; i <= upper; i++) {
			weight[i] = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i] = -1;
		}
		weight[n] = 0;

		for (int x = lower; x <= upper; x++) {
			int minVer = minVertex(lower, upper, visited, weight);

			visited[minVer] = true;
			for (Integer v : adj[minVer]) {
				if (weight[minVer] + 1 <= weight[v]) {
					weight[v] = weight[minVer] + 1;
					parent[v] = minVer;
				}

			}

		}

		int x = n;
		int total = 1;

		int par = parent[m];

		while (par != n) {

			par = parent[par];

			if (par == n) {
				total++;

				break;
			}
			total++;

		}

		return total;

	}

}
// 99 100 50 25 26 13 14 7 8 4 2 3 for 3 99
