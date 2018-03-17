package knightTour;

import java.util.Arrays;

public class knightTour {

	public static final int N = 8;

	public boolean isSafe(int x, int y, int[][] storeNumber) {
		if (x >= 0 && y >= 0 && x < N && y < N && storeNumber[x][y] == -1) {
			return true;
		}
		return false;

	}

	public void printSolution(int storeNumber[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				System.out.print(storeNumber[x][y] + " ");
			System.out.println();
		}
	}

	public void solveKt() {
		int x_move[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
	    int y_move[] = {  1, 2,  2,  1, -1, -2, -2, -1 };
		int[][] storeNumber = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				storeNumber[i][j]=-1;
			}
		}
		
		storeNumber[0][0] = 0;
		if (!solveKtUtil(0, 0, 1, storeNumber, x_move, y_move)) {
			System.out.println("no solution");
		} else {
			printSolution(storeNumber);
		}

	}

	private  boolean solveKtUtil(int x, int y, int move_number, int[][] storeNumber, int[] x_move, int[] y_move) {
		
		if(move_number==N*N) {
			return true;
		}
		
		int next_x, next_y;
		for (int k = 0; k < 8; k++) {
			
			next_x = x + x_move[k];
			next_y = y + y_move[k];
			if (isSafe(next_x, next_y, storeNumber)) {
				storeNumber[next_x][next_y] = move_number;
				if (solveKtUtil(next_x, next_y, move_number + 1, storeNumber, x_move, y_move)) {
					return true;
				}
				else {
					storeNumber[next_x][next_y]=-1;
				}
			}
	
		}

		return false;
	}
	public static void main(String [] args) {
		knightTour k = new knightTour();
		k.solveKt();
	}

}
