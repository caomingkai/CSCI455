import java.util.GregorianCalendar;
import java.util.Calendar;

public class Date {
  public static void main(String[] args){
      // GregorianCalendar cal = new GregorianCalendar(1995,1,20);

        GregorianCalendar cal = new GregorianCalendar();
        cal.set(1995,Calendar.JANUARY,20);

        int date = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        System.out.println(month+"/"+date+"/"+year);

        cal.add(Calendar.DAY_OF_MONTH, 20);
        date = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH)+1;
        year = cal.get(Calendar.YEAR);
        System.out.println(month+"/"+date+"/"+year);
        System.out.println(cal.get(Calendar.HOUR)+"-"+cal.get(Calendar.MINUTE)+"-"+cal.get(Calendar.SECOND));
  }

}
