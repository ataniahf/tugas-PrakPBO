
package bangunruang;


public class Lingkaran {
    int jari2;
    double luas,keliling;
    
    Lingkaran(int jari2){
        this.jari2=jari2;
    }

    public int getjari2() {
        return jari2;
    }
     
     double luas(){
         luas = 3.14*(jari2*jari2);
        return luas;
     }
     double keliling(){
         keliling = 3.14*(2*jari2);
         return keliling;
     }
}
