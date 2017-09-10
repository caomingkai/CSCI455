public interface Measurer
{
	double measure(Object anObject);
}

public static double average(Object[] objects, Measurer meas)
{
	double sum = 0;
	for (Object obj : objects){
		sum = sum + meas.measure(obj);
	}
	if (objects.length > 0) { 
		return sum / objects.length; }
	else { 
		return 0; }
}

public class AreaMeasurer implements Measurer
{
	public double measure(Object anObject)
	{
		Rectangle aRectangle = (Rectangle) anObject;
		double area = aRectangle.getWidth() * aRectangle.getHeight();
		return area;
	}
}





