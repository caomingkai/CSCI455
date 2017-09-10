// TestReadLine: what happens when we combine next/nextInt, etc. with
// nextLine?
// -- Does nextLine read the next line of input, or the rest of the current
// line of input?


import java.util.Scanner;

public class ReadLine {
    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);

	// System.out.print("Please enter your age: ");
	// int age = in.nextInt();

	System.out.print("Please enter your whole name: ");
  String name = in.next();

  System.out.println("Name:" + name);


	// System.out.println("You are awesome, " + name + "!");
	// System.out.println("And so young.  Only " + age + "!");

    }
}
