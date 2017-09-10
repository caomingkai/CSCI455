import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map;

public class EntryComparator implements Comparator<Map.Entry<String,Integer>>{
	
	public int compare(Map.Entry<String,Integer> entry1 , Map.Entry<String,Integer> entry2 ){

		return entry2.getValue() - entry1.getValue();
	}
}