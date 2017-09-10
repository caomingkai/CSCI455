/**
   This class tests the CashReg class with changes from ex4
   and uses the Change class.
   Version for CS 455 lab 3.  Modified from version from Big Java, 4th ed.
   Also tests getTotal() accessor function.
*/
public class CashRegTester
{
   public static void main(String[] args)
   {
      CashReg register = new CashReg();

      register.recordPurchase(4.35);
      System.out.print("Total: ");
      System.out.println(register.getTotal());
      System.out.println("Expected: 4.35");
      System.out.println();

      Change payment = new Change(5, 0, 0, 0, 0);
      register.enterPayment(payment);
      System.out.println("Payment given: " + payment);
                                    // Java automatically calls toString()

      Change change = register.giveChange();
      System.out.println(change);    // Java automatically calls toString()
      System.out.print("Change total: ");
      System.out.println(change.totalValue()/100.0);
      System.out.println("Expected: 0.65");
      System.out.println();

      register.recordPurchase(0.75);
      System.out.print("Total: ");
      System.out.println(register.getTotal());
      System.out.println("Expected: 0.75");
      System.out.println();

      register.recordPurchase(1.50);
      System.out.print("Total: ");
      System.out.println(register.getTotal());
      System.out.println("Expected: 2.25");
      System.out.println();

      payment = new Change(2, 0, 5, 0, 0);
      register.enterPayment(payment);
      System.out.println("Payment given: " + payment);
      change = register.giveChange();
      System.out.println(change);
      System.out.print("Change total: ");
      System.out.println(change.totalValue()/100.0);
      System.out.println("Expected: 0.25");
      System.out.println();

      register.recordPurchase(2.25);
      System.out.print("Total: ");
      System.out.println(register.getTotal());
      System.out.println("Expected: 2.25");
      System.out.println();

      register.recordPurchase(19.25);
      System.out.print("Total: ");
      System.out.println(register.getTotal());
      System.out.println("Expected: 21.5");
      System.out.println();


      payment = new Change(23, 2, 0, 0, 0);
      register.enterPayment(payment);
      System.out.println("Payment given: " + payment);
      change = register.giveChange();
      System.out.println(change);
      System.out.print("Change total: ");
      System.out.println(change.totalValue()/100.0);
      System.out.println("Expected: 2.0");
      System.out.println();
   }
}
