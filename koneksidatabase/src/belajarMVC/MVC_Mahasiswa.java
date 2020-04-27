
package belajarMVC;


public class MVC_Mahasiswa {
    ViewMahasiswa viewmahasiswa = new ViewMahasiswa();
    ModelMahasiswa modelmahasiswa = new ModelMahasiswa();
    ControllerMahasiswa controllermahasiswa = new ControllerMahasiswa(modelmahasiswa,viewmahasiswa);
}
