import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;

public class Birthday {
  public static void main(String[] args){
	  
	    String a = "";
	    System.out.println(a.length());
	  	
        GregorianCalendar curDay = new GregorianCalendar();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your birth month [1..12]: ");
        int birthMonth = in.nextInt();// 0-based for MONTH

        System.out.print("Enter your birth day of month: ");
        int birthDay = in.nextInt();

        System.out.print("Enter your birth year [4-digit year]: ");
        int birthYear = in.nextInt();

        int day = curDay.get(curDay.DAY_OF_MONTH);
        int month = curDay.get(curDay.MONTH)+1;
        int year = curDay.get(curDay.YEAR);
        int age = 0;
        if(birthMonth < month || birthMonth == month && birthDay < day){
          System.out.println("Your birthday has not yet happened this year.");
          age = year - birthYear-1;
          if(age < 0){ age = 0; }
        }else{
          System.out.println("Your birthday has already happened this year.");
          age = year - birthYear;
          if(age < 0){ age = 0; }
        }
        System.out.println("You're " + age + " years old.");
        System.out.println();
  }
}
