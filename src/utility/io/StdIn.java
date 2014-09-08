package utility.io;

import java.util.Scanner;


public final class StdIn {

	private StdIn(){}

	public static Scanner scanner;
	
	static{
		StdIn.scanner = new Scanner(new java.io.BufferedInputStream(System.in));
	}

	public static String  readLine(){
		String line;
		try { line = scanner.nextLine();}
		catch(Exception ex){ line = null ;}
		return line;
	}
	
	public static String  readString(){
		return scanner.next();
	}
	
	public static Integer readInt() {
		return scanner.nextInt();
	}
	
	public static Double readDouble(){
		return scanner.nextDouble();
	}

	public static void main(String[] args) {

		System.out.println("print By : "+StdIn.readLine());
	}

}
