import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
/**
 * Created by kevin on 09/05/2017.
 */
public class A {

    public String name;
    public int score;
   

    public A(){
    	 name = "a" ;
    	 score = 1;
    }

}

 class ScoreComparator implements Comparator<A>{
	public int compare( A a1, A a2){

		if( a1.score != a2.score ){
			return a1.score - a2.score;
		}else{
			return a1.name.compareTo(a2.name);
		}
	}
	
}


