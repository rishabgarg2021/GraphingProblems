import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer[]> cubes = new ArrayList<Integer[]>();
		
		while ( sc.hasNext() ) {

			int corners = sc.nextInt();
			
			corners = (int) Math.pow(2, corners);

			Integer[] weights = new Integer[corners];

			for (int i = 0; i < corners; i++) {

				weights[i] = sc.nextInt();
				

			}

			cubes.add(weights);
			
		

		}
		

		for (int i = 0; i < cubes.size(); i++) {

			int neigWeight[] = new int[cubes.get(i).length];
			Integer[] actualWeights = cubes.get(i);
			int total = 0;
			for (int j = 0; j < neigWeight.length; j++) {
				total += actualWeights[j];
				for (int z = 0; z < Math.log(neigWeight.length) / Math.log(2); z++) {
					int c = j ^ (1 << z);
				
					total += actualWeights[c];
				

				}
				neigWeight[j] = total;
			
				total = 0;

			}
		
			int score = -1;
			int neighbours = (int) (Math.log(neigWeight.length) / Math.log(2));
			
			for (int h = 0; h <Math.pow(2, neighbours); h++) {
				for (int n = 0; n < neighbours; n++) {
					int check=h ^ (1 << n);
				
			
					
					if (score < (neigWeight[h] + neigWeight[check] - actualWeights[h] - actualWeights[check])) {
						score = neigWeight[h] + neigWeight[check] - actualWeights[h] - actualWeights[check];
					}

				}
			}
			System.out.println(score);

		}
	}

}
