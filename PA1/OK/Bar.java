// Name:Mingkai Cao
// USC NetID:7151889244
// CS 455 PA1
// Spring 2017

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 */
public class Bar {
    /**
        Creates a labeled bar.  You give the height of the bar in application
        units (e.g., population of a particular state), and then a scale for how
        tall to display it on the screen (parameter scale).

        @param bottom  location of the bottom of the label
        @param left  location of the left side of the bar
        @param width  width of the bar (in pixels)
        @param barHeight  height of the bar in application units
        @param scale  how many pixels per application unit
                    1 pixel/app unit = ( component.getHeight() - 2*vb -labelHeight)/ 100;
                    divide the remaining height of the componet into 100 pieces
        @param color  the color of the bar
        @param label  the label at the bottom of the bar
    */

    private int bottom;
    private int left;
    private int width;
    private int barHeight;
    private double scale;
    private Color color;
    private String label;

    /**
        constructor with arguments
    */
    public Bar(int bottom, int left, int width, int barHeight,
               double scale, Color color, String label){
        this.bottom = bottom;
        this.left = left;
        this.width = width;
        this.barHeight = barHeight;
        this.scale = scale;
        this.color = color;
        this.label = label;
    }


    /**
        Draw the labeled bar.
        @param g2  the graphics context
    */
    public void draw(Graphics2D g2) {

        int widthOfLabel = 0; // width of the label in pixels
        int heightOfLabel = 0;// height of the label in pixels
        int labelLeft = 0;    // location of the left side of the label
        int barHeightY = 0;   // height of the bar in pixels, not in application units


        // Obtain the width of this.label to place it centered,
        // and the height of this.label to calculate buffer-space height
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D   labelBounds = font.getStringBounds(this.label, context);
        widthOfLabel = (int)labelBounds.getWidth();
        heightOfLabel = (int)labelBounds.getHeight();


        // calculate the labelLeft value in order to place it in the center
        labelLeft = left - (widthOfLabel - width)/2;

        // draw the label to place it in the center
        g2.setColor(Color.BLACK);
        g2.drawString(this.label, labelLeft, bottom);

        // calculate height of the bar in pixels, not in application-units
        barHeightY = (int)(bottom - heightOfLabel - barHeight * scale);
        Rectangle rectangleBar = new Rectangle(left, barHeightY ,width, (int)(barHeight * scale));

        // draw the bar
        g2.setColor(color);
        g2.fill(rectangleBar);


   }
}
