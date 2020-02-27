
package bangunruang;



public class Balok extends PersegiPanjang{
    int tinggi;
    double volume,luaspermukaan;
    Balok(int panjang, int lebar, int tinggi) {
       super(panjang,lebar);
       this.tinggi=tinggi;
    }
    double volume(){
        volume = super.luas()*tinggi;
        return volume;
    }
  

    double luaspermukaan() {
        luaspermukaan = (super.keliling()*2)+((super.getLebar()+tinggi)*2)+((super.getPanjang()+tinggi)*2);
        return luaspermukaan;   
    }
}