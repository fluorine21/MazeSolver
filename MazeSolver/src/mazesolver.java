import java.util.Scanner;

public class mazesolver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();
		in.close();
		
		maze mainMaze = new maze(filename);
		mainMaze.generateNodeArray();
		


	}

}
