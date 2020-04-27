import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author ATANIA
 */
public class Menu_Data extends JFrame{
    JButton input,tampil,hapus,edit,exit;
    JLabel judul;
    
    public Menu_Data(){
        
        setTitle("Contact List");
        
        judul = new JLabel("MENU");
        
        input = new JButton("Input Contact List");
        tampil = new JButton("Tampil Contact List");
        hapus = new JButton("Hapus Contact List");
        edit = new JButton("Update Contact Liat");
        exit = new JButton("EXIT");
        
        setLayout(null);
        add(judul);
        add(input);
        add(edit);
        add(hapus);
        add(tampil);
        add(exit);
        
        judul.setBounds(210,100,100,25);
        input.setBounds(125,130, 200, 25);
        tampil.setBounds(125, 160, 200, 25);
        hapus.setBounds(125, 190, 200, 25);
        edit.setBounds(125, 220, 200, 25);
        exit.setBounds(125, 250, 200, 25);
        
        setSize(500,500);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        input.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new Create_Data();
            }
        });
        
        edit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Data();
            }
        });
        
        hapus.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new Delete_Data();
            }
        });
        
        tampil.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
              new Read_Data();
                
            }
        });
        
        exit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
}
