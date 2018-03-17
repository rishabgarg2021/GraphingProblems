import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Lexigraphic {
	private int v;
	private LinkedList<Integer> adj[];

	public Lexigraphic(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v, int[] indegree) {
		adj[u].add(v);
		if (indegree[u] == -1) {
			indegree[u] = 0;
		}
		;
		if (indegree[v] == -1) {
			indegree[v] = 1;
		} else {
			indegree[v]++;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Lexigraphic g = new Lexigraphic(26);
		ArrayList<Character> alph = new ArrayList<>();
		int[] indegree = new int[26];
		for (int i = 0; i < 26; i++) {

			alph.add((char) (97 + i));
			indegree[i] = -1;

		}
		int number = sc.nextInt();
		sc.nextLine();
		int i = 0;
		ArrayList<String> words = new ArrayList<String>();
		while (i != number) {

			words.add(sc.nextLine());
			i++;
		}
		int j = 0;
		ArrayList<Integer> input = new ArrayList<>();
		if (words.size() > 1) {
			for (int k = 0; k + 1 < words.size(); k++) {

				j = 0;
				String a = words.get(k);
				String b = words.get(k + 1);
				int l1 = a.length();
				int l2 = b.length();
				boolean flag = true;
				while (l1 != 0 && l2 != 0) {

					if (a.charAt(j) != b.charAt(j)) {

						g.addEdge(alph.indexOf(a.charAt(j)), alph.indexOf(b.charAt(j)), indegree);
						input.add(alph.indexOf(a.charAt(j)));
						input.add(alph.indexOf(b.charAt(j)));
						flag = false;
						break;

					}
					l1--;
					l2--;
					j++;

				}

				if (l1 > l2 && flag) {

					System.out.println("Impossible");
					return;
				}

			}

			// add elements to al, including duplicates
			Set<Integer> hs = new LinkedHashSet<Integer>(input);
			input.clear();
			input.addAll(hs);

			if (input.size() > 1) {
				boolean[] visited = new boolean[26]; // j+1edges
				// ArrayList<Integer> res = new ArrayList<>();

				Arrays.fill(visited, false);
				boolean[] recStack = new boolean[26]; // j+1edges
				// ArrayList<Integer> res = new ArrayList<>();

				Arrays.fill(recStack, false);
				Stack stack = new Stack();

				int source = -1;
				for (i = 0; i < 26; i++) {

					if (indegree[i] == 0) {
						source = i;
					}
				}
				int t = 26;
				int dist[][] = new int[t][2];
		
				if (source != -1) {

					for (i = 0; i < t; i++) {
						dist[i][0] = Integer.MIN_VALUE;
						dist[i][1] = -1;
					}

					dist[source][0] = 0;
					dist[source][1] = -1;
				}
				for (i = 0; i < input.size(); i++) {
					if (!visited[input.get(i)]) {

						if (source != -1 && !g.tSortUtilCycle(input.get(i), stack, visited, recStack)) {
							
						}
						else {

							System.out.println("Impossible");
							return;
						}
					}

					
				}

				while (!stack.empty()) {
					int n = (int) stack.pop();

					for (int node : g.adj[n]) {

						if (1 + dist[n][0] > dist[node][0] && dist[n][0] != Integer.MIN_VALUE) {

							dist[node][0] = 1 + dist[n][0];
							dist[node][1] = n;

						}
					}

				}

				Stack newStack = new Stack();
				int max = Integer.MIN_VALUE;
				int child = -2;

				for (i = 0; i < input.size(); i++) {

					if (dist[input.get(i)][0] > max) {
						max = dist[input.get(i)][0];
						child = input.get(i);

					}
				}

				newStack.push(child);
				i = dist[child][1];

				while (i != -1) {
					newStack.push(i);
					i = dist[i][1];

				}
				// System.out.println(newStack);
				boolean[] visit = new boolean[26];
				Arrays.fill(visit, false);

				for (i = newStack.size() - 1; i >= 0; i--) {

					visit[(int) newStack.elementAt(i)] = true;
				}

				while (newStack.size() != 0) {

					for (i = 0; i <= 25; i++) {
						if (!visit[i] && i < (int) newStack.elementAt(newStack.size() - 1)) {
							System.out.print((char) (97 + i));
							visit[i] = true;
						}

					}
					System.out.print((char) (97 + (int) newStack.elementAt(newStack.size() - 1)));

					newStack.pop();
				}
				for (i = 0; i < 26; i++) {
					if (!visit[i]) {
						System.out.print((char) (97 + i));
					}
				}
			} else {

				for (i = 0; i < 26; i++) {

					System.out.print((char) (97 + i));
				}

			}
		} else {

			for (i = 0; i < 26; i++) {

				System.out.print((char) (97 + i));
			}
		}

	}

	public boolean tSortUtilCycle(int i, Stack stack, boolean[] visited, boolean[] recStack) {
		visited[i] = true;

		recStack[i] = true;

		for (int n : adj[i]) {
			if (!visited[n]) {
				if (tSortUtilCycle(n, stack, visited, recStack)) {
					return true;
				}
				;

			} else if (recStack[i]) {

				return true;
			}

		}
		// once the path is fully traversed push it in the stack as there is no chance
		// to visit more vertex from this vertex.\
		recStack[i] = false;
		stack.push(i);
		return false;

	}

}
