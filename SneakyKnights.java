// Samuel Bermuez sa167851
// COP 3503 Summer 2018

import java.io.*;
import java.util.*;
import java.lang.Object;
import java.util.HashMap;

	class knights
	{
		HashMap<Integer, Integer> square;
		
		public knights (HashMap<Integer,Integer> square)
		{
			this.square = square;
		}
		
		public HashMap<Integer, Integer> getSquare()
		{
			return square;
		}
	}
	

public class SneakyKnights
{
	public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardSize)
	{
		int size = coordinateStrings.size();
		int i, j;
		int Rval = 0;
		int Cval = 0;
		int length;
		
		knights tempKnight;
		HashMap<Integer, Integer> newKnight;
		knights []board = new knights[size];
		
		for(i = 0; i < size; i++)
		{
			if(coordinateStrings.get(i).length() != 0)
			{
			Rval = Integer.parseInt(coordinateStrings.get(i).replaceAll("[^\\d]","")) - 1;	
			
			String temp = coordinateStrings.get(i).replaceAll("[\\d]", "");
			length = temp.length();
			Cval = 0;
			
			for(j = 0; j < length; j++)
			Cval += (int)(temp.charAt(j)- 96)*Math.pow( 26, length - j - 1);
			Cval--;
			
			System.out.println("Rval: " + Rval);
			if(board[Rval] == null)
			{	newKnight = new HashMap<Integer,Integer>();
				newKnight.put(Cval,1);
				board[Rval] = new knights(newKnight);
			}
			else
				board[Rval].getSquare().put(Cval,1);
			
			if(Rval + 1 < boardSize && (Cval + 2 < boardSize || Cval - 2 >= 0))
			{
				if(board[Rval + 1] != null)
				{
					if(Cval + 2 < boardSize && board[Rval+1].getSquare().containsKey(Cval + 2))
						return false;
					if(Cval - 2 >= 0 && board[Rval + 1 ].getSquare().containsKey(Cval - 2))
						return false;
				}
			}
			
			if(Rval - 1 >= 0 && (Cval + 2 < boardSize || Cval - 2 >= 0))
			{
				if(board[Rval - 1] != null)
				{
					if(Cval + 2 < boardSize && board[Rval - 1].getSquare().containsKey(Cval + 2))
						return false;
					if(Cval - 2 >= 0 && board[Rval - 1].getSquare().containsKey(Cval - 2))
						return false;
				}
			}
			
				if(Rval + 2 < boardSize && (Cval + 1 < boardSize || Cval - 1 >= 0))
			{
				if(board[Rval + 2] != null)
				{
					if(Cval + 1 < boardSize && board[Rval + 2].getSquare().containsKey(Cval + 1))
						return false;
					if(Cval - 1 >= 0 && board[Rval + 2].getSquare().containsKey(Cval - 1))
						return false;
				}
			}
			
			if(Rval - 2 >= 0 && (Cval + 1 < boardSize || Cval - 1 >= 0))
			{
				if(board[Rval - 2] != null)
				{
					if(Cval + 1 < boardSize && board[Rval - 2].getSquare().containsKey(Cval + 1))
						return false;
					if(Cval - 1 >= 0 && board[Rval - 2].getSquare().containsKey(Cval - 1))
						return false;
				}
			}
			}
		}
		return true;
	}
	
	public static double difficultyRating()
	{
		return 5.0;
	}
	
	public static double hoursSpent()
	{
		return 5.0;
	}
	
	
}