import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private int v;
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();

		}

	}

	public void addEdge(int v, int w) {
		adj[v].add(w);

	}

	public void BFS(int s) {
		boolean visited[] = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);
		while (queue.size() != 0) {
			s = queue.poll();
			System.out.println(s + "  ");
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					queue.add(n);
					visited[n] = true;
				}
			}
		}

	}

	public void DFS(int s) {
		boolean visited[] = new boolean[v];
		LinkedList<Integer> stack = new LinkedList<>();
		LinkedList<Integer> printed = new LinkedList<>();
		stack.addFirst(s);
		while (stack.size() != 0) {
			s = stack.poll();
			if (!visited[s]) {
				System.out.println(s);

				printed.add(s);

				visited[s] = true;
			}

			Iterator<Integer> i = adj[s].listIterator();

			while (i.hasNext()) {

				int n = i.next();
				if (printed.contains(n)) {
					System.out.println("cyclic");
				}
				if (!visited[n]) {
					stack.addFirst(n);

				}
			}
		}
	}

	public void DFSUTIL(int s, Integer[] visited) {
		if (visited[s] == 0) {
			System.out.println(s);
			visited[s]++;
			for (Integer j : adj[s]) {
				if (visited[j] == 1) {
					System.out.println("cyclic");
				}
				if (visited[j] == 0) {
					DFSUTIL(j, visited);
				}

			}
		}
	}

	public void newDFS(int s) {

		Integer visited[] = new Integer[v];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
		for (int i = 1; i < v; i++) {
			if (visited[i] == 0) {
				DFSUTIL(i, visited);
			}
		}

	}

	public void TopologicalSort() {
		boolean visited[] = new boolean[v];
		Stack stack = new Stack<>();
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;

		}
		for (int i = 1; i < v; i++) {
			if (visited[i] == false) {
				tSortUtil(i, stack, visited);
			}
		}
		System.out.println("tsort starts");
		while (!stack.isEmpty()) {

			System.out.println(stack.pop() + "   here");
		}
	}

	public void tSortUtil(int n, Stack stack, boolean[] visited) {
		visited[n] = true;
		// System.out.println(n);
		Iterator<Integer> it = adj[n].iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (visited[i] == false) {
				tSortUtil(i, stack, visited);
			}
		}
		stack.push(new Integer(n));
	}

	public void biPartite() {
		int start = 1;

		boolean flag = false;
		Boolean[] colors = new Boolean[v];
		boolean change = false;
		colors[start] = flag;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addFirst(start);
		boolean visited[] = new boolean[v];

		while (queue.size() != 0) {

			start = queue.pollLast();

			System.out.println(start);

			if (change || start == 1) {
				flag = !flag;
				change = !change;
			}
			for (Integer j : adj[start]) {
				if (!visited[j]) {
					change = true;
					queue.addFirst(j);
					colors[j] = flag;
					visited[j] = true;

				}
			}

		}

		for (int i = 1; i < v; i++) {
			if (colors[i]) {
				System.out.println("first  " + i);

			} else {
				System.out.println("second  " + i);
			}
		}

	}

}
