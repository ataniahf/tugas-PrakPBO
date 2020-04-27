import java.awt.event.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ATANIA
 */
public class Update_Data extends JFrame{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbcontact";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama", "NoHP", "Umur","EMmail"};
    
    JLabel ljudul = new JLabel("UPDATE CONTACT LIST");
    JLabel lnama = new JLabel("Nama : ");
    JTextField tnama = new JTextField();
    JLabel lno_hp = new JLabel("No Telepon : ");
    JTextField tno_hp = new JTextField(); 
    JLabel lumur = new JLabel("Umur : ");
    JTextField tumur = new JTextField();
    JLabel lemail = new JLabel("Email : ");
    JTextField temail = new JTextField();
    JButton btnUpdate = new JButton("Update");
    JButton btnBatal = new JButton("Batal"); 
    
    
    public Update_Data(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Database Berhasil");
        }   catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Database Gagal");
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(550, 600);
        
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);        
        add(scrollPane);
        scrollPane.setBounds(20, 270, 480, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(ljudul);
        add(lnama);
        add(lno_hp);
        add(lumur);
        add(lemail);
        add(tnama);
        add(tno_hp);
        add(tumur);
        add(temail);
        
        ljudul.setBounds(200, 10, 300, 60);
        lnama.setBounds(40, 80, 80, 20);
        tnama.setBounds(140, 80, 220, 20);        
        lno_hp.setBounds(40, 110, 80, 20);        
        tno_hp.setBounds(140, 110, 220, 20);        
        lumur.setBounds(40, 140, 80, 20);        
        tumur.setBounds(140, 140, 220, 20);        
        lemail.setBounds(40, 170, 80, 20);        
        temail.setBounds(140, 170, 220, 20);        
        
        add(btnUpdate);
        add(btnBatal);
        btnUpdate.setBounds(140, 220, 80, 30);        
        btnBatal.setBounds(350, 220, 80, 30);        
        //table.setDefaultRenderer(Object.class, new RenderWarnaWarni(Color.BLUE, Color.RED));

        btnBatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                setVisible (false);
                new Menu_Data();
            }
        });
        
        btnUpdate.addActionListener((ActionEvent e) -> {
            if (tnama.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "Form tidak boleh kosong!");
            } else {
                
                String nama = tnama.getText();
                String no_hp = tno_hp.getText();
                String umur = tumur.getText();
                String email = temail.getText();
                             
                this.simpanContact(nama, no_hp, umur,email);
  
                String dataContact[][] = this.readContact();
                table.setModel(new JTable(dataContact,namaKolom).getModel());
            }
        });
        
        if (this.getBanyakData() != 0) {  
            String dataContact[][] = this.readContact();  
            table.setModel((new JTable(dataContact, namaKolom)).getModel());
             
        } else {
            JOptionPane.showMessageDialog(null, "Contact Tidak Ada!");
        }
        
        table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){ 
               int baris = table.getSelectedRow();
               int kolom = table.getSelectedColumn();  
               String dataterpilih = table.getValueAt(baris, 0).toString();
           }
        });

}
    
    public void simpanContact(String nama, String no_hp, String umur, String email) {
        try{
            String query ="UPDATE contact SET no_hp='" + tno_hp.getText() + "',"+ "umur='" +tumur.getText() + "',"+ "email='" +temail.getText() +"' WHERE nama='" + tnama.getText() + "'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Contact berhasil diedit");
            JOptionPane.showMessageDialog(null,"Contact berhasil diedit "+nama+"");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }        
    }
    String[][] readContact() {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakData()][4];
            String query = "Select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("no_hp");
                data[jmlData][2] = resultSet.getString("umur");
                data[jmlData][3] = resultSet.getString("email");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println(" ERROR! ");
            return null;
        }
    }

    int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println(" ERROR! ");
            return 0;
        }
    }

 
    

    
}
