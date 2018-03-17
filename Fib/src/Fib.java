import java.util.*;

public class Fib {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 1, b = 1, c = 0;
		for (int i = 1; i <= n; i++) {
			if (i == b) {
				System.out.print("O");
				c = a + b;
				a = b;
				b = c;
			} else {
				System.out.print("o");
			}
		}
	}
}