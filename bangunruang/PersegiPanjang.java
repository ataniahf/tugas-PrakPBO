
package bangunruang;


public class PersegiPanjang {
     int panjang,lebar;
    double luas,keliling;
    PersegiPanjang(int panjang, int lebar) {
       this.panjang = panjang;
       this.lebar = lebar;
    }

    public int getPanjang() {
        return panjang;
    }

    public int getLebar() {
        return lebar;
    }
    
    double luas(){
        luas = panjang*lebar;
        return luas;
    }
    double keliling(){
        keliling = (panjang+lebar)*2;
        return keliling;
    } 
}
