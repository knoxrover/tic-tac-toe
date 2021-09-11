import java.util.*;
public class tictactoe {
	
	public static void rungame() {
		String winner = "";
		boolean xTurn = true;
		int r = 0;
		int c = 0;
		String[][] gameBoard = new String[3][3];
		
		initGB(gameBoard);
		printGB(gameBoard);
		
		while(winner.equals("")) {
			if(xTurn) {
				System.out.println("Its X's turn. ");
			}
			else {
				System.out.println("Its O's turn. ");
			}
			
			
			getinp(xTurn,gameBoard);
			System.out.println();
			
			printGB(gameBoard);
			winner  = getWinner(gameBoard);
			xTurn = !xTurn;
			
			if(winner.equals("") && isGbFull(gameBoard)) {
				winner = "C";
			}
			
		}
		
		System.out.println();
		
		
		
		if(winner.equals("C")) {
			System.out.println("Its the cats game! NO WINNER");
			
		}
		else {
			System.out.println("The winner is "+winner);
		}
		
	}
	
	public static void initGB(String[][] gameBoard) {
		for(int i=0;i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard[i].length;j++) {
				gameBoard[i][j] = " ";
			}
			
		}
		
	}
	
	
	
	public static void printGB(String[][] gameBoard) {
		for(int i=0;i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard[i].length;j++) {
				System.out.print(gameBoard[i][j]);
				if(j<2) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if(i<2) {
				System.out.println("- - - - -");
			}
			
			System.out.println();
		}
	}

	public static void getinp(boolean xTurn,String[][] gameBoard) {
		
		Scanner s = new Scanner(System.in);
		
		int r = -1;
		int c = -1;
		boolean keepAsking = true;
		
		
		while(keepAsking) {
			System.out.println("Please enter the row then,"
					+"the column, each from 0, 1 or 2 "
					+"seperated by space");
			
			
			r = s.nextInt();
			c = s.nextInt();
			s.nextLine();
			
			
			if(r>=0 && r <=2 && c>=0 && c<=2) {
				if(!cellAlreadyOccupied(r,c,gameBoard)) {
					keepAsking= false;
				}
				else {
					System.out.println("Cell is already Occupied");
				}
				
			}
		}
		
		
		
		if(xTurn) {
			gameBoard[r][c] = "X";
		}
		else {
			gameBoard[r][c]= "O";
		}
		
		
	}
	
	public static boolean cellAlreadyOccupied(int r, int c, String[][] gameBoard) {
		return !gameBoard[r][c].equals(" ");
	}

	public static String getWinner(String[][] gameBoard){
		
		final int r = gameBoard.length;
		final int c = gameBoard[0].length;
		
		
		for(int i=0;i<r;i++) {
			if(!gameBoard[i][0].equals(" ")
					&& gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][1].equals(gameBoard[i][2])) {
				return gameBoard[i][0];
			}
		}
		

		for(int i=0;i<c;i++) {
			if(!gameBoard[0][i].equals(" ")
					&& gameBoard[0][i].equals(gameBoard[1][i]) && gameBoard[1][i].equals(gameBoard[2][i])) {
				return gameBoard[0][i];
			}
		}
		
		
			if(!gameBoard[0][0].equals(" ")
					&& gameBoard[0][0].equals(gameBoard[1][1]) 
					&& gameBoard[1][1].equals(gameBoard[2][2])) {
				
				return gameBoard[0][0];
		}
			
			if(!gameBoard[2][0].equals(" ")
					&& gameBoard[2][0].equals(gameBoard[1][1]) 
					&& gameBoard[1][1].equals(gameBoard[0][2])) {
				
				return gameBoard[2][2];
		}
		
		
			
			return "";
	}
	
	
	public static boolean isGbFull(String[][] gameBoard) {
		boolean k = true;
		
		for(int i=0;i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard[i].length;j++) {
				if(gameBoard[i][j]==" ") {
					k = false;
					break;
				}
			}
		}
		return k;
	}
	
	
	public static void main(String[] args) {
			rungame();
	}

}
