//Samuel Bermudez
// 09/10/2018
import java.io.*;
import java.util.*;

// Main used for testing SneakyKnights.
public class SneakyMain
{
	public static void main(String [] args) throws Exception
	{
		Scanner in = new Scanner(new File(args[0]));
		ArrayList<String> list = new ArrayList<String>();

		// Read each line from the input file into the ArrayList.
		while (in.hasNext())
			list.add(in.next());
		
		try {
		int boardSize = Integer.parseInt(args[1]);
		System.out.println((SneakyKnights.allTheKnightsAreSafe(list, boardSize) == true) ? "Knights are safe" : "Unsafe Knight present");
		} catch (NumberFormatException e) {
			System.err.println("NumberFormatException: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
		}
		
	}
}
