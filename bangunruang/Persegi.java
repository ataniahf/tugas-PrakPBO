
package bangunruang;


public class Persegi {
     int sisi;
    double luas,keliling;
    
    Persegi(int sisi){
        this.sisi=sisi;
    }

    public int getSisi() {
        return sisi;
    }
     
     double luas(){
         luas = sisi*sisi;
        return luas;
     }
     double keliling(){
         keliling = sisi*4;
         return keliling;
     } 
}
