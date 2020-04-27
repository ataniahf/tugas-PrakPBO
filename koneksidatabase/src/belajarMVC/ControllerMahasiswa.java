package belajarMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerMahasiswa {

    ModelMahasiswa modelmahasiswa;
    ViewMahasiswa viewmahasiswa;

    public ControllerMahasiswa(ModelMahasiswa modelmahasiswa, ViewMahasiswa viewmahasiswa) {
        this.modelmahasiswa = modelmahasiswa;
        this.viewmahasiswa = viewmahasiswa;

        if (modelmahasiswa.getBanyakData() != 0) {
            String dataMahasiswa[][] = modelmahasiswa.readMahasiswa();
            viewmahasiswa.tabel.setModel((new JTable(dataMahasiswa, viewmahasiswa.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewmahasiswa.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = viewmahasiswa.getNim();
                String nama = viewmahasiswa.getNamaMhs();
                String alamat = viewmahasiswa.getAlamatMhs();
                String telepon = viewmahasiswa.getTeleponMhs();
                modelmahasiswa.insertMahasiswa(nim, nama, alamat, telepon);

                String dataMahasiswa[][] = modelmahasiswa.readMahasiswa();
                viewmahasiswa.tabel.setModel(new JTable(dataMahasiswa, viewmahasiswa.namaKolom).getModel());
            }
        });
        
        

       viewmahasiswa.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewmahasiswa.tabel.getSelectedRow();
                int kolom = viewmahasiswa.tabel.getSelectedColumn();

                String dataterpilih = viewmahasiswa.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NIM" + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelmahasiswa.deleteMahasiswa(dataterpilih);
                    String dataMahasiswa[][] = modelmahasiswa.readMahasiswa();
                    viewmahasiswa.tabel.setModel(new JTable(dataMahasiswa, viewmahasiswa.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }
}
