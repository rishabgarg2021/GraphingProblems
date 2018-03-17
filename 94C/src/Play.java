import java.util.Scanner;

public class Play {

	public boolean isSafe(char board[][], int x_move, int y_move) {
		if (x_move > 7 || y_move > 7 || x_move < 0 || y_move < 0 || board[x_move][y_move] == 't') {
			return false;
		}
		if (board[x_move][y_move] == '.' || board[x_move][y_move] == 'A' || board[x_move][y_move] == 'S') {
			return true;
		}
		return false;
	}

	public boolean win(char board[][], int x_move, int y_move) {
		if (x_move > 7 || y_move > 7 || x_move < 0 || y_move < 0) {
			return false;
		}
		if (board[0][7] == 'M') {
			return true;
		}
		return false;
	}

	public boolean moveStatue(char board[][], int total,int a , int b) {
		
		for (int i = 0; i+1 < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'S' && a==i+1 && b==j) {
					//System.out.println("no");
					return false;

				}

			}
		}
		for(int k=0;k<8;k++) {
			if (board[7][k]=='S') {
				board[7][k]='.';
			}
		}
		for (int z = 0; z < 8; z++) {
			if (board[0][z] == 'S') {
				board[0][z]='.';
				board[1][z]='S';
			}
		}
		for (int i = 6; i > 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'S' ) {
					board[i][j]='.';
					board[i+1][j]='S';
					

				}

			}
		}

		return true;
	}

	public boolean play(int x, int y, int[] x_move, int[] y_move, char[][] board, int total) {
		if (win(board, x, y)) {
			return true;
		}
		for (int i = 0; i < 8; i++) {

			int a = x + x_move[i];

			int b = y + y_move[i];
//			System.out.println();
//			
//			printing(board);
//			System.out.println();
//			System.out.println();

			if (isSafe(board, a, b) && moveStatue(board, total,a,b)) {

				if(board[x][y]=='S') {
					
				}
				else {
					board[x][y]='.';
				}
				board[a][b] = 'M';
//				System.out.println();
//			
//				printing(board);
//				System.out.println();
//				System.out.println();

				if ( play(a, b, x_move, y_move, board, total)) {

					return true;
				}

				else {
//					System.out.println("error");
					revertStatue(board);
					board[x][y] = 'M';
					board[a][b] = '.';
//					
//					System.out.println("new");
//					
//					printing(board);
//					System.out.println("new");
//					System.out.println();

					
				}

			}

		}
		// System.out.println(":here");
		return false;
	}

	private void revertStatue(char[][] board) {
		
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'S' ) {
					
					board[i-1][j]='S';
					board[i][j]='.';

				}

			}
		}
		
	}

	public void printing(char[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		char board[][] = new char[8][8];
		Play p = new Play();
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int i = 0;
		while (i != 8) {
			char[] line = sc.nextLine().toCharArray();
			board[i] = line;
			i++;
		}
		for (i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'S') {
					total++;
				}
			}
		}
		//System.out.println("read");
		int[] xmove = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] ymove = { -1, 0, 1, 1, 1, 0, -1, -1 };
		if (p.play(7, 0, xmove, ymove, board, total)) {
			System.out.println("WIN");
		} else {
			System.out.println("LOSE");
		}
		;

	}

}
