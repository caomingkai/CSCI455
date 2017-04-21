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
 * Provide the numOfTrials for the simulation,
 * and a frame to show the three bars
 */

public class CoinSimViewer {
  public static void main(String[] args)
  {
    // prompt for input
    System.out.print("Enter number of trials: ");
    Scanner in = new Scanner(System.in);
    int numOfTrials = in.nextInt();

    // examinate the input for a correct num type
    while(numOfTrials <= 0){
      System.out.println("ERROR: Number entered must be greater than 0.");
      System.out.print("Enter number of trials: ");
      numOfTrials = in.nextInt();
    }

    JFrame frame = new JFrame();

    frame.setSize(800 , 500);  // 800 width and 500 height
    frame.setTitle("Coin Toss Simulation");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    // int frameWidth = frame.getWidth();
    // int frameHeight = frame.getHeight();
    // System.out.println("frameWidth: "+frameWidth);
    // System.out.println("frameHeight: "+frameHeight);

    CoinSimComponent component = new CoinSimComponent(numOfTrials);
    frame.add(component);
    frame.setVisible( true );
  }
























}
