public class Test{ 

	public static void main( String argv[]){

		int n = 8;
		System.out.println( "fibSeq " + n +" is: " + fibSeq(n) );
	}

	public static int fibSeq( int n ){

		if( n == 1 || n == 2){
			return 1;
		}
		int temp = 1;
		int former = 1;
		int latter = 1;

		for( int i = 3; i <= n; i++){
			temp = former + latter;
			former = latter;
			latter = temp;
		}
		return temp;
	}
		
}