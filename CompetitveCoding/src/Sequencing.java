import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Lumberjacks:");
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();

			String[] s1 = s.split(" ");

			boolean flag = true;
			if (s1.length >= 2) {
				int compare = Integer.parseInt(s1[1]) - Integer.parseInt(s1[0]);

				for (int j = 1; j < s1.length; j++) {

					int toCompare = Integer.parseInt(s1[j]) - Integer.parseInt(s1[j - 1]);
					if (compare >= 0 && toCompare < 0) {
						flag = false;
						break;
					}
					if (compare <= 0 && toCompare > 0) {
						flag = false;
						break;
					}

				}
				if (!flag) {
					System.out.println("Unordered");
				} else {
					System.out.println("Ordered");
				}
			} 
			else {
				System.out.println("Ordered");
			}

		}
	
	}
	
}
