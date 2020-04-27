
package RunningTextApp;
//mengimpor class
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author ATANIA
 */
//deklarasi kelas
public class RunningText extends JPanel {
 int x =0, y = 200;
 //method paint
 public void paint(Graphics g) 
 {
 //memanggil method paint dari superclass
 super.paint(g);
 Graphics2D g2 = (Graphics2D) g;
 //mengatur tulisan dan warna
 Font font = new Font("Comic Sans MS", Font.BOLD+Font.PLAIN+Font.ITALIC,50);
 g2.setFont(font);
 g2.setColor(Color.red);
 g2.drawString("Tulisan Ini Berjalan... ",x,y);
 
 //exception handling  
 try 
 {
  Thread.sleep(200);
 }
 catch(Exception ex) {}
 x+=5;
 if(x>this.getWidth()) {
   x=0;
}
 repaint();
}
 //method main
public static void main(String[] args) 
{
 JFrame jf = new JFrame("Running Text");
 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 jf.setSize(700,400);
 jf.add(new RunningText());
 jf.setVisible(true);
}
}
