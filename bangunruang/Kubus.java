
package bangunruang;


public class Kubus extends Persegi {
    double volume,luaspermukaan;
    Kubus(int sisi) {
     super(sisi);    
    }
    
    double volume(){
        this.volume = super.luas()*super.getSisi();
        return volume;
    }
    
    public double luaspermukaan(){
        luaspermukaan = super.luas()*6;
        return luaspermukaan;
    }

}
