
package bangunruang;


public class Tabung extends Lingkaran{
    int tinggi;
    double volume,luaspermukaan;
    Tabung(int jari2, int tinggi){
       super(jari2);
       this.tinggi=tinggi;
    }
    double volume(){
        volume = super.luas()*tinggi;
        return volume;
    }
    
    double luaspermukaan() {
        luaspermukaan = (2*super.keliling()*tinggi);
        return luaspermukaan;   
    }
}
