import java.util.*;

public class TicTacToe
{
	static Scanner reader = new Scanner(System.in);
	static String[][] board = new String[3][3];
	static String turn;
	
	public static void main(String[] args)
	{		
		turn = "X";
		buildBoard();
		playGame();
	}
	
	public static void playGame()
	{
		char winner = '1';
		for(int turns = 0; turns < 9; turns++) 
		{
			if(turn == "X")
				turn = "O";
			else
				turn = "X";
			
			System.out.println("It is " + turn + "'s turn. Where do you wish to play, " + turn + "?");
			
			getMove();
			printBoard();
			
			winner = checkWinner();
			if(winner != '1')
			{
				System.out.println("Congrats " + winner + "! You win!");
				return;
			}
		}
		
		System.out.println("nobody won :(. play again!");
	}
	
	public static char checkWinner()
	{
		String line = null;
		
		for(int i = 0; i < 8; i++)
		{
			switch(i)
			{
				case 0:
					line = board[0][0] + board[0][1] + board[0][2];
					break;
				case 1:
					line = board[1][0] + board[1][1] + board[1][2];
					break;
				case 2:
					line = board[2][0] + board[2][1] + board[2][2];
					break;
				case 3:
					line = board[0][0] + board[1][0] + board[2][0];
					break;
				case 4:
					line = board[0][1] + board[1][1] + board[2][1];
					break;
				case 5:
					line = board[0][2] + board[1][2] + board[2][2];
					break;
				case 6:
					line = board[0][0] + board[1][1] + board[2][2];
					break;
				case 7:
					line = board[0][2] + board[1][1] + board[2][0];
					break;
			}
			
			if(line.equals("XXX"))
			{
				return 'X';
			}
			else if(line.equals("OOO"))
			{
				return 'O';
			}
			
		}
		return '1';
	}
	
	
	public static void getMove()
	{
		String input = reader.next();

		char jc = input.charAt(0);
		char ic = input.charAt(1);
		
		int j;
		if(jc == 'a' || jc == 'A')
		{
			j = 0;
		}
		else if(jc == 'b' || jc == 'B')
		{
			j = 1;
		}
		else if(jc == 'c' || jc == 'C')
		{
			j = 2;
		}
		else return;
		
		int i = ic - '0';
		i--;
		if(board[i][j] == "-")
		{
			board[i][j] = turn;
		}
		else
		{
			System.out.println("that spot has already been taken. please, pick another.");
			getMove();
		}
	}
	
	
	public static void printBoard()
	{
		System.out.print("\nthe current board: ");
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println();
			for(int j = 0; j < 3; j++)
			{
				System.out.print(board[i][j]);
			}
		}
		
		System.out.println("\n");
	}
	
	
	public static void buildBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j]="-";
			}
		}
	}
}

// abc
//1
//2
//3
	
