
package belajarMVC;

import java.awt.Color;
import static java.awt.SystemColor.window;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewMahasiswa extends JFrame {
    
    JLabel lNim = new JLabel("Nim : ");
    JTextField tfnim = new JTextField();
    JLabel lNamaMhs = new JLabel ("Nama Mahasiswa : ");
    JTextField tfNamaMhs = new JTextField();
    JLabel lAlamatMhs = new JLabel ("Alamat Mahasiswa : ");
    JTextField tfAlamatMhs = new JTextField();
    JLabel lTeleponMhs = new JLabel ("Telepon Mahasiswa : ");
    JTextField tfTeleponMhs = new JTextField();
    
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
      
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;  //buat scroll
    JLabel lJudul = new JLabel("DATA MAHASISWA");
    Object namaKolom[] = {"NIM","Nama","Alamat","Telepon"}; //membuat kolom dalam array
        
    public ViewMahasiswa(){
            
        tableModel = new DefaultTableModel(namaKolom,0); //0 baris
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

            
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,500);
        
        //TABEL
        add(scrollPane);
        scrollPane.setBounds(420,50,500,400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            
        add(lNim);
        lNim.setBounds(20, 50, 90, 20);
        add(tfnim);
        tfnim.setBounds(180, 50, 120, 20);
        add(lNamaMhs);
        lNamaMhs.setBounds(20, 75, 200, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(180, 75, 120, 20);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(20, 100, 130, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(180, 100, 120, 20);
        add(lTeleponMhs);
        lTeleponMhs.setBounds(20, 125, 130, 20);
        add(tfTeleponMhs);
        tfTeleponMhs.setBounds(180, 125, 120, 20);
        
        add(btnTambahPanel);
        btnTambahPanel.setBounds(180, 150, 90, 20);
        
        add(btnBatalPanel);
        btnBatalPanel.setBounds(310, 150, 90, 20);
        
        add(lJudul);
        lJudul.setBounds(645,10,200,20);
}
        public String getNim(){
            return tfnim.getText();
        }
        
        public String getNamaMhs(){
            return tfNamaMhs.getText();
        }
        
        public String getAlamatMhs(){
            return tfAlamatMhs.getText();
        }
        public String getTeleponMhs(){
            return tfTeleponMhs.getText();
        }
}

