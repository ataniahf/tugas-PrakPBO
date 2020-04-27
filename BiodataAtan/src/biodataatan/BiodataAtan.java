package biodataatan;

/**
 *
 * @author ATANIA
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class BiodataAtan {

   
    public static void main(String[] args) {
       Bio b = new Bio();
    }  
}
class Bio extends JFrame {
    private String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    private String months[] = { "Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des" };
    private String years[] = { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
			"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
			"2020" }; 
    private String[] namaAgama = {"Islam","Kristen","Katolik","Hindu","Budha"};
   JLabel ljudul = new JLabel ("REGISTRASI MAHASISWA ");
   JLabel gambar = new JLabel(new ImageIcon(getClass().getResource(("UPN.jpg"))));
   JLabel lnama = new JLabel("Nama ");
   JTextField tnama = new JTextField();
   JLabel lnim = new JLabel("NIM ");
   JTextField tnim = new JTextField();
   JLabel ltglahir = new JLabel("TTL  ");
   JComboBox date = new JComboBox(dates);
   JComboBox month = new JComboBox(months);
   JComboBox year = new JComboBox(years);
   JLabel lagama = new JLabel("Agama ");
   JComboBox cmbAgama = new JComboBox(namaAgama);
   JRadioButton rbPria = new JRadioButton(" Laki-Laki ");
   JRadioButton rbWanita = new JRadioButton(" Perempuan ");
   JLabel alamat = new JLabel ("Alamat");
   final JTextArea falamat = new JTextArea(20, 20);    
   JButton btnedit = new JButton ("Edit");
   JButton btnSave = new JButton("Save");
   
   

   public Bio() {
       setTitle("Registrasi Mahasiswa");
	setDefaultCloseOperation(3);
	setSize(480,650);
        setLocation(500, 50);

	ButtonGroup group = new ButtonGroup();
	group.add(rbPria);
	group.add(rbWanita);
        
        btnSave.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Halamandua dua = new Halamandua();
               dispose();
           }
           
       });

	setLayout(null);
        add(ljudul);
        add(gambar);
	add(lnama);
        add(tnama);
        add(lnim);
        add(tnim);
	add(ltglahir);
        add(date);
        add(month);
        add(year);
	add(rbPria);
	add(rbWanita);
        add(lagama);
        add(cmbAgama);
        add(alamat);
        add(falamat);
        add(btnedit);
	add(btnSave);

        ljudul.setBounds(150,25,150,20);
        gambar.setBounds(95,50,240,240);
	lnama.setBounds(50,300,80,20);
        tnama.setBounds(150,300,170,20);
        lnim.setBounds(50,320,80,20);
        tnim.setBounds(150,320,170,20);
        ltglahir.setBounds(50,340,100,20);
        date.setBounds(150,340,50,20);
        month.setBounds(200,340,60,20);
        year.setBounds(260,340,60,20);
        lagama.setBounds(50,360,170,20);
        cmbAgama.setBounds(150,360,170,20);
	rbPria.setBounds(150,380,100,20);
	rbWanita.setBounds(270,380,100,20);
        alamat.setBounds(50,425,120,20);
        falamat.setBounds(150,425,250,75);
        btnedit.setBounds(150,530,120,30);
	btnSave.setBounds(280,530,120,30);
	setVisible(true);
   }
}