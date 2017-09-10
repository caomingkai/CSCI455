// Name: Mingkai Cao
// USC NetID: 7151889244
// CS 455 PA1
// Spring 2017

import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 * class CoinSimViewer
 * 1 - Provides the numOfTrials for the simulation
 * 2 - Creates a frame to show graph of the outcome
 */
public class CoinSimViewer {
  public static void main(String[] args)
  {
    int numOfTrials = 0; //store input from the User, as

    // prompt for input
    System.out.print("Enter number of trials: ");
    Scanner in = new Scanner(System.in);
    numOfTrials = in.nextInt();

    // check the input for a correct num type
    while(numOfTrials <= 0){
      System.out.println("ERROR: Number entered must be greater than 0.");
      System.out.print("Enter number of trials: ");
      numOfTrials = in.nextInt();
    }

    JFrame frame = new JFrame();

    frame.setSize(800 , 500);  // 800 width and 500 height
    frame.setTitle("CoinSim");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    CoinSimComponent component = new CoinSimComponent(numOfTrials);
    frame.add(component);
    frame.setVisible( true );
  }
























}
