import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author ATANIA
 */
public class Create_Data extends JFrame{
    JLabel lnama,lno_hp,lumur,lemail,judul;
    JTextField txnama,txno_hp,txumur,txemail;
    Statement statement;
    JButton simpan,btnBatal;
   
    
    public Create_Data(){
    setTitle("INPUT CONTACT LIST");
    
        judul = new JLabel("INPUT CONTACT LIST");
        lnama = new JLabel("Nama : ");
        lno_hp = new JLabel("No Telepon : ");  
        lumur = new JLabel("Umur : ");
        lemail = new JLabel("Email : ");
        
        txnama = new JTextField("");
        txno_hp = new JTextField("");
        txumur = new JTextField("");
        txemail = new JTextField("");
        
        btnBatal = new JButton("BATAL");
        simpan = new JButton("SIMPAN");
        
        setLayout(null);
        add(judul);
        add(lnama);
        add(lno_hp);
        add(lumur);
        add(lemail);
        
        add(txnama);
        add(txno_hp);
        add(txumur);
        add(txemail);
        
        add(simpan);
        add(btnBatal);
        
        judul.setBounds(210,80,300,30);
        lnama.setBounds(125, 125, 100, 25);
        txnama.setBounds(225, 125, 150, 25);
        lno_hp.setBounds(125, 160, 100, 25);
        txno_hp.setBounds(225, 160, 150, 25);
        lumur.setBounds(125, 195, 100, 25);
        txumur.setBounds(225, 195, 150, 25);
        lemail.setBounds(125, 230, 100, 25);
        txemail.setBounds(225, 230, 150, 25);
        simpan.setBounds(125, 265, 100, 25);
        btnBatal.setBounds(250,265, 100, 25);
        
        setSize(500,500); 
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnBatal.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Menu_Data();
            }
        });
        
        simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String a1 = txnama.getText();
                int a2 =  Integer.parseInt(txno_hp.getText());
                int a3 = Integer.parseInt(txumur.getText());
                String a4 = txemail.getText();
                        
                Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("INSERT INTO contact VALUES ('"+ a1 + "','" + a2 + "','" + a3 +"','"+ a4 + "')");
                        JOptionPane.showMessageDialog(rootPane, "Contact Berhasil Tersimpan");
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Create_Data.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Create_Data.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    
                } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(rootPane,"KESALAHAN PADA TIPE DATA ANDA!");
                } catch (Error ext){
                 JOptionPane.showMessageDialog(rootPane,"TERJADI KESALAHAN!");
                 
                }
                
            }

        });
    }
}
