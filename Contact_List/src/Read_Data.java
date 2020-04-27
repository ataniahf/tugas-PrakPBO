import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author ATANIA
 */
public class Read_Data extends JFrame {
    String[] [] data = new String [500] [4]; //baris, kolom
    String[] kolom = {"Nama","NoHP","Umur","Email"}; //menamai kolom di atasnya, ga harus sama kayak di database
    JLabel judul;
    JTable tabel;
    JButton btnKembali;
    JScrollPane scrollPane;
    Statement statement;
    ResultSet resultSet;
    
    public Read_Data(){
        setTitle("TAMPILAN CONTACT LIST");
        
        judul = new JLabel("CONTACT LIST");
        btnKembali = new JButton("Kembali");
        tabel = new JTable(data,kolom);
        scrollPane = new JScrollPane(tabel);
        
        
        //tabel.setDefaultRenderer(Object.class, new RenderWarnaWarni(Color.BLUE, Color.RED));
        pack();
        setLayout(null);
       
        add(btnKembali);
        add(judul);
        add(scrollPane);
        
        judul.setHorizontalAlignment(SwingConstants.CENTER);
        setSize(500,500);
        
        judul.setBounds(130,20,200,25);
        scrollPane.setBounds(20,60,450,350);
        btnKembali.setBounds(350,420,100,20);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        btnKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
               new Menu_Data();
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
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan","hasil", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan","hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
