import java.util.Scanner;

// ReadName: practice with reading and writing

// Warning: this version has a mistake

public class ReadName {
    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);

	System.out.print("Please enter your first name: ");
	String name1 = in.next();
	String name2 = in.next();
  String name3 = in.next();
	String name4 = in.next();

  System.out.println("Name1: " + name1 );
  System.out.println("Name2: " + name2 );
  System.out.println("Name3: " + name3 );
  System.out.println("Name4: " + name4 );
	// System.out.print("Please enter your age: ");
	// int age = in.nextInt();
  //
	// System.out.println("You are awesome, " + name + "!");
	// System.out.println("And so young.  Only " + age + "!");

    }
}
