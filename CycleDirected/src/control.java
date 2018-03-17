import java.util.Scanner;

public class control {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String f = sc.nextLine();
		String[] first = new String[3];
		first = f.split("\\s");
		Cycle g = new Cycle(Integer.parseInt(first[0]+1));
		int one;
		int two;
		while (sc.hasNext()) {
			String s = sc.nextLine();

			String[] n = new String[2];
			n = s.split("\\s");
			one = Integer.parseInt(n[0]);
			two = Integer.parseInt(n[1]);
			g.addEdge(one, two);

		}
		// g.addEdge(0, 1);
		// g.addEdge(0, 2);
		// g.addEdge(1, 2);
		// g.addEdge(2, 0);
		// g.addEdge(2, 3);
		// g.addEdge(3, 3);
		if (g.detectCycle()) {
			// System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
