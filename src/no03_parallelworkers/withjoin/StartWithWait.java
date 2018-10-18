package no03_parallelworkers.withjoin;

import java.util.Scanner;

public class StartWithWait extends StartWithJoin{
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Press enter to start");
			scanner.nextLine();
		}
		new StartWithJoin().doIt(args);
	}
}

