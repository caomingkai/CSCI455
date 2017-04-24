// Name: Mingkai Cao
// USC loginid: mingkaic
// CS 455 PA3
// Spring 2017

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
/**
   MazeComponent class
   
   A component that displays the maze and path through it if one has been found.
*/
   public class MazeComponent extends JComponent
   {

   private static final int START_X = 10; // top left of corner of maze in frame
   private static final int START_Y = 10;
   private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
   private static final int BOX_HEIGHT = 20;
   private static final int INSET = 2;  
                    // how much smaller on each side to make entry/exit inner box
   private Maze maze;
   /**
      Constructs the component.
      @param maze   the maze to display
   */
      public MazeComponent(Maze maze) 
      {   
        this.maze = maze;
      }


   /**
     Draws the current state of maze including the path through it if one has
     been found.
     @param g the graphics context
   */
     public void paintComponent(Graphics g){ 

        int row = maze.numRows();
        int col = maze.numCols();
        MazeCoord entryLoc = maze.getEntryLoc();
        MazeCoord exitLoc = maze.getExitLoc();
        LinkedList<MazeCoord> path = maze.getPath();
        Graphics2D g2 = (Graphics2D) g;

        // draw the border
        borderDraw(row, col, g2);

        // draw maze  
        mazeDraw(row, col, g2);

        // draw entryLoc 
        entryLocDraw(entryLoc, g2);
        

        // draw exitLoc
        exitLocDraw(exitLoc, g2);

        //draw path
        pathDraw(path, g2);
     }

   /**
     Draws the border of the maze
     @param g2 the graphics2D context
     @param row the number of rows of the maze
     @param col the number of columns of the maze
   */
     private void borderDraw(int row, int col, Graphics2D g2){

        int x1 = START_X ;
        int y1 = START_Y ;
        Rectangle box = new Rectangle(x1, y1, col * BOX_WIDTH, row * BOX_HEIGHT);
        g2.draw(box);
     }

   /**
     Draws the maze
     @param g2 the graphics2D context
     @param row the number of rows of the maze 
     @param col the number of columns of the maze
   */
     private void mazeDraw(int row, int col, Graphics2D g2){

        for(int i = 0; i < row; i++){
          for(int j = 0; j < col; j++){
            MazeCoord curLoc = new MazeCoord(i, j);
            if( maze.hasWallAt(curLoc) ){
              int x1 = START_X + j * BOX_WIDTH;
              int y1 = START_Y + i * BOX_HEIGHT;
              g2.setColor(Color.BLACK);
              g2.fill( new Rectangle(x1, y1, BOX_WIDTH, BOX_HEIGHT) );
            }
          }
        }
     }

   /**
     Draws the entry location of the maze
     @param entryLoc the location of the entry
     @param g2 the graphics2D context
   */
     private void entryLocDraw(MazeCoord entryLoc, Graphics2D g2){

        int x1 = START_X + entryLoc.getCol() * BOX_WIDTH + INSET;
        int y1 = START_Y + entryLoc.getRow() * BOX_HEIGHT + INSET;
        g2.setColor(Color.YELLOW);
        Rectangle box = new Rectangle(x1, y1, BOX_WIDTH - INSET - INSET, BOX_HEIGHT - INSET - INSET);
        g2.fill(box);
     }

   /**
     Draws the exit location of the maze
     @param exitLoc the location of the entry
     @param g2 the graphics2D context
   */
     private void exitLocDraw(MazeCoord exitLoc, Graphics2D g2){

        int x1 = START_X + exitLoc.getCol() * BOX_WIDTH + INSET;
        int y1 = START_Y + exitLoc.getRow() * BOX_HEIGHT + INSET;
        g2.setColor(Color.GREEN);
        Rectangle box = new Rectangle(x1, y1, BOX_WIDTH - INSET - INSET, BOX_HEIGHT - INSET - INSET);
        g2.fill(box);
     }

   /**
     Draws the path from the entryLoc to the exitLoc
     @param path the path made up with a series of locations
     @param g2 the graphics2D context
   */
     private void pathDraw(LinkedList<MazeCoord> path, Graphics2D g2){

        final int NEXT_ONE = 1;
        final int RATIO = 2;

        if( path != null){
            int length = path.size();
            for(int i = 0; i < length - 1; i++){

              MazeCoord curPos = path.get(i);
              int x1 = START_X + curPos.getCol()  * BOX_WIDTH  + BOX_WIDTH / RATIO;
              int y1 = START_Y + curPos.getRow()  * BOX_HEIGHT + BOX_WIDTH / RATIO;

              MazeCoord nextPos = path.get( i + NEXT_ONE );
              int x2 = START_X + nextPos.getCol() * BOX_WIDTH  + BOX_WIDTH / RATIO;
              int y2 = START_Y + nextPos.getRow() * BOX_HEIGHT + BOX_WIDTH / RATIO;

              Point2D.Double from = new Point2D.Double(x1, y1);
              Point2D.Double to = new Point2D.Double(x2, y2);
              Line2D.Double segment = new Line2D.Double(from, to);
              g2.setColor(Color.RED);
              g2.draw(segment);
            }
        }
     }


     
}


