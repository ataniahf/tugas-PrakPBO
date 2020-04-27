import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ATANIA
 */
public class Delete_Data extends JFrame {
    String[] [] data = new String [500] [4]; 
    String[] kolom = {"Nama", "NoHP", "Umur","Email"}; 
    JLabel judul;
    JTable tabel;
    JButton btnKembali,btnHapus;
    JScrollPane scrollPane;
    Statement statement;
    ResultSet resultSet;
    public static String dataterpilih;
    
    public Delete_Data(){
        
        setTitle("CONTACT LIST");
        
        judul = new JLabel("CONTACT LIST");
        btnKembali = new JButton("Kembali");
        btnHapus = new JButton("Hapus");   
        tabel = new JTable(data,kolom);
        scrollPane = new JScrollPane(tabel);
      
        pack();
        setLayout(null);
       
        add(judul);
        add(scrollPane);
        add(btnKembali);
        add(btnHapus);
        
        judul.setHorizontalAlignment(SwingConstants.CENTER);
        setSize(500,500);
        
        judul.setBounds(150,20,200,25);
        scrollPane.setBounds(20,60,450,350);
        btnKembali.setBounds(250,420,100,20);
        btnHapus.setBounds(120,420,100,20);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        btnKembali.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Menu_Data();
            }
        });
        
        
        tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
        int baris = tabel.getSelectedRow();
        int kolom = tabel.getSelectedColumn();
        dataterpilih = tabel.getValueAt(baris, 0).toString();
        
        System.out.println(dataterpilih);
        btnHapus.addActionListener((java.awt.event.ActionEvent f) -> {
            btnBuatactionListener();
        });
            }
            
             private void btnBuatactionListener(){
        
        Koneksi koneksi = new Koneksi();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("DELETE FROM contact WHERE nama='" + dataterpilih + "'");
                        JOptionPane.showMessageDialog(null, "Contact berhasil di Hapus!","Hasil", JOptionPane.INFORMATION_MESSAGE);
                        statement.close();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Contact tidak ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    }
        
    }
        });
        
         Koneksi koneksi = new Koneksi();        
        try{
            
            statement = koneksi.getKoneksi().createStatement();
            
            String sql = "SELECT * FROM contact";
            resultSet = statement.executeQuery(sql);
            
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("nama"); 
                data[p][1] = resultSet.getString("no_hp");
                data[p][2] = resultSet.getString("umur");
                data[p][3] = resultSet.getString("email");
                p++;
            }
            statement.close();
        }
        
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Contact gagal ditampilkan","hasil", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Contact tidak ditemukan","hasil", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
}
