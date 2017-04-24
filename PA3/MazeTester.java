

public class MazeTester{

		private static final int INVALID = -2;
	    private static final int STOP = -1;
	    private static final int FINISH =  1;
	    private static final int CONTINUE = 0;

	   public static final boolean PASSED = true;
	   public static final boolean NOT_PASSED = false;
	   public static final boolean FOUND = true;
	   public static final boolean NOT_FOUND = false;

	    public static void main(String[] args)  {
		boolean[][] mazeData = { {false , false, true, false} , {true, false, false, false} };
		MazeCoord start = new MazeCoord(0, 0);
		MazeCoord exit = new MazeCoord(0, 3);

		Maze myMaze = new Maze( mazeData, start, exit);

		// System.out.println(myMaze.toString());
		// // System.out.println(myMaze.toString2());


		// System.out.println(myMaze.numRows());
		// System.out.println(myMaze.numCols());
		// System.out.println(myMaze.hasWallAt(new MazeCoord(0,0)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(0,1)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(0,2)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(0,3)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(0,4)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(1,0)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(1,1)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(1,2)));
		// System.out.println(myMaze.hasWallAt(new MazeCoord(1,3)));

		// System.out.println(myMaze.getEntryLoc());
		// System.out.println(myMaze.getExitLoc());
		// System.out.println(myMaze.toStringPath());


		// //-----setPassed / isPassed
		// System.out.println(myMaze.toStringMazePassed());
		// System.out.println("isPassed before set(1,1):" + myMaze.isPassed(new MazeCoord(1,1)));
		// // myMaze.setPassed( new MazeCoord(1,1) );
		// System.out.println("isPassed after  set(1,1):" + myMaze.isPassed(new MazeCoord(1,1)));
		// System.out.println(myMaze.toStringMazePassed());
		

		// // directionStatus()   
		// //--(1,1) is setPassed
		// //--(0,2) (1,0) is wall
		// //--()
		// System.out.println("----directionStatus()  ----");
		// System.out.println(myMaze.getExitLoc());
		// if( myMaze.directionStatus( new MazeCoord(1,8) ) == INVALID ){
		// 	System.out.println("(1,8) is INVALID");
		// }
		// if(myMaze.directionStatus( new MazeCoord(1,1) ) == STOP){
		// 	System.out.println("(1,1) is PASSED, this way should be stopped");
		// }
		// if(myMaze.directionStatus( new MazeCoord(0,2) ) == STOP){
		// 	System.out.println("(0,2) is WALL, this way should be stopped");
		// }
		// if(myMaze.directionStatus( new MazeCoord(1,0) ) == STOP){
		// 	System.out.println("(1,0) is WALL, this way should be stopped");
		// }
		// if(myMaze.directionStatus( new MazeCoord(0,0) ) == CONTINUE){
		// 	System.out.println("(0,0) is CONTINUE");
		// }
		// if(myMaze.directionStatus( new MazeCoord(1,3) ) == CONTINUE){
		// 	System.out.println("(1,3) is CONTINUE" );
		// }
		// System.out.println(myMaze.toStringPath());
		

		// // ----search()----
		// System.out.println("----search()----");
		// System.out.println(myMaze.search());
		// System.out.println("getPath() : " + myMaze.getPath() );
		// System.out.println(myMaze.toStringPath());
		
	}
}