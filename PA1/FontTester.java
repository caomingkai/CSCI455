import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.geom.Rectangle2D;

public class FontTester {

 public  static class BarComponent extends JComponent{
   public void paintComponent(Graphics g){
     Graphics2D g2 = (Graphics2D)g;
     int gWidth = getWidth();
     int gHeight = getHeight();
     System.out.println("ComponetWidth: "+gWidth);
     System.out.println("ComponetHeight: "+gHeight);

     //fixed distance from label bottom to lower border of the graph,
     // same with the upper border
     // Y_PADDING should larger than labelHeight, to make scale occupy exactly 100 pieces
     String label = "labelllllllllllll";
    //  g2.drawString(label , 100, 100);
     Font font = g2.getFont();
     FontRenderContext context = g2.getFontRenderContext();
     Rectangle2D   labelBounds = font.getStringBounds(label, context);
     int widthOfLabel = (int)labelBounds.getWidth();
     int heightOfLabel = (int)labelBounds.getHeight();
    //  int heightOfLabel = 50;
     System.out.println("heightOfLabel : "+heightOfLabel);

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
