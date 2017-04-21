 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.Color;
 import java.awt.Rectangle;
 import javax.swing.JFrame;
 import javax.swing.JComponent;
 import java.awt.geom.Rectangle2D;
 import java.awt.Font;
 import java.awt.font.FontRenderContext;


public class BarTester {

  public  static class BarComponent extends JComponent{
    public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D)g;
      int gWidth = getWidth();
      int gHeight = getHeight();
      System.out.println("ComponetWidth: "+gWidth);
      System.out.println("ComponetHeight: "+gHeight);


      String label = "just for test the 'heightOfLabel'  ";
      // the Label is not drawed on now
      //  g2.drawString(label , 100, 100);
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D   labelBounds = font.getStringBounds(label, context);
      int heightOfLabel = (int)labelBounds.getHeight();

      //fixed distance from label bottom to lower border of the graph,
      // same with the upper border
      // Y_PADDING should larger than labelHeight, to make scale occupy exactly 100 pieces
      int Y_PADDING = 50;
      int bottom = gHeight-Y_PADDING;
      double scale = ( gHeight - 2 * Y_PADDING  - heightOfLabel) / 100.0;

      int width = 100;
      int xPadding = (gWidth - 3 * width) / 4;
      int left1 = xPadding;
      int left2 = 2*xPadding + width;
      int left3 = 3*xPadding + 2*width;
      int numTwoHeads = 30;
      int percentTwoHeads = 100;

      String label1 = "Two Head: " + numTwoHeads + "(" + percentTwoHeads + "%)";
      Bar bar1 = new Bar(bottom, left1, width, percentTwoHeads, scale, Color.RED , label1);
      bar1.draw(g2);
    }
  }
  
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();

    frame.setSize(600 , 600);
    frame.setTitle("Bar Tester");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    int frameWidth = frame.getWidth();
    int frameHeight = frame.getHeight();
    System.out.println("frameWidth: "+frameWidth);
    System.out.println("frameHeight: "+frameHeight);

    //Frame needs Component to draw the specific shape(eg. Bar)

    BarComponent component = new BarComponent();

    frame.add(component);
    System.out.println("=======================");
    frame.setVisible( true );
  }
























}
