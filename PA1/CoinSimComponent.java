// Name: Mingkai Cao
// USC NetID: 7151889244
// CS 455 PA1
// Spring 2017

import java.awt.geom.Rectangle2D;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 * class CoinSimComponent
 *
 * 1 - Get the numOfTrials from Clas CoinSimViewer
 * 2 - Run the simulation using CoinTossSimulator()
 * 3 - Draw each bar corresponding to simulation result.
 *|------'use what'---------------------------------------------
 *|     coinTossSimulator() : conduct simulation
 *|     Bar() :  draw different Bars
 *|------'be used by what'--------------------------------------
 *|     CoinSimViewer() : have Frame to contain CoinSimComponent
 *|--------------------------------------------------------------
 */

public class CoinSimComponent extends JComponent{
    /**
        @param numTwoHeads  cumulative results of TWO_HEAD after run() is executed.
        @param numTwoTails  cumulative results of TWO_TAIL after run() is executed.
        @param numHeadTails  cumulative results of HEAD_TAIL after run() is executed.
        @param numOfTrials   cumulative results for all the outcomes after run() is executed.
    */
    private int numTwoHeads;
    private int numTwoTails;
    private int numHeadTails;
    private int numOfTrials;

    /**
        constructor with an argument 'numOfTrials'
        @param numOfTrials  number of toss trials
    */
    public CoinSimComponent(int numOfTrials){

        // create an CoinTossSimulator object to run the simulation
        CoinTossSimulator simulator = new CoinTossSimulator();
        simulator.run(numOfTrials);

        numTwoHeads = simulator.getTwoHeads();
        numTwoTails = simulator.getTwoTails();
        numHeadTails = simulator.getHeadTails();
        this.numOfTrials = numOfTrials;
      }


    /**
        paint the each bar regarding to the toss-result
        @param g
    */
    public void paintComponent( Graphics g){

        //Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;

        final int Y_PADDING = 30; // fixed distance from label bottom to the upper and lower border of the graph
        final int BAR_WIDTH = 100;// fixed width of each bar
        final int APPLICATION_UNIT_GROSS = 100;// how many application_units for 100% barHeight



        int gWidth = getWidth();            // get the width of the component
        int gHeight = getHeight();          // get the height of the component
        int bottom = gHeight - Y_PADDING;   // location of the bottom of the label
        int xPadding = (gWidth - 3 * BAR_WIDTH) / 4;  // buffer-space between bars and windows

        // calculate the heightOfLabel in order to determine the scale
        String label = "just for testing the 'heightOfLabel'  ";
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D   labelBounds = font.getStringBounds(label, context);
        int heightOfLabel = (int)labelBounds.getHeight();

        double scale = ( gHeight - 2 * Y_PADDING - heightOfLabel ) / (double)(APPLICATION_UNIT_GROSS);


        // 1st bar for TwoHeads
        int left1 = xPadding;   //location of the left side of the bar
        int percentTwoHeads = (int)Math.round( numTwoHeads / (double)numOfTrials * APPLICATION_UNIT_GROSS);
        String label1 = "Two Head: " + numTwoHeads + "(" + percentTwoHeads + "%)";
        Bar bar1 = new Bar(bottom, left1, BAR_WIDTH, percentTwoHeads, scale, Color.RED , label1);
        bar1.draw(g2);

        // 2nd bar for TwoTails
        int left2 = 2 * xPadding + BAR_WIDTH;   //location of the left side of the bar
        int percentHeadTails = (int)Math.round( numHeadTails / (double)numOfTrials * APPLICATION_UNIT_GROSS);
        String label2 = "A Head and a Tail: " + numHeadTails + "(" + percentHeadTails + "%)";
        Bar bar2 = new Bar(bottom, left2, BAR_WIDTH, percentHeadTails, scale, Color.GREEN , label2);
        bar2.draw(g2);


        // 3rd bar for HeadTails
        int left3 = 3 * xPadding + 2 * BAR_WIDTH;   //location of the left side of the bar
        int percentTwoTails = (int)Math.round( numTwoTails /(double)numOfTrials * APPLICATION_UNIT_GROSS);
        String label3 = "Two Tails: " + numTwoTails + "(" + percentTwoTails + "%)";
        Bar bar3 = new Bar(bottom, left3, BAR_WIDTH, percentTwoTails, scale, Color.BLUE , label3);
        bar3.draw(g2);
    }
}
