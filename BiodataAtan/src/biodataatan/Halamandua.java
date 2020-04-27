
package biodataatan;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author ATANIA
 */
public class Halamandua extends JFrame{
    JLabel kalimat;

    public Halamandua(){
    kalimat = new JLabel ("Selamat Registrasi Anda Berhasil");

    setLayout(null);
        add(kalimat);
        kalimat.setBounds(75,150,400,50);
        kalimat.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        kalimat.setForeground(Color.blue);
        setSize(500,400);
        setLocation(600, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
    
}
