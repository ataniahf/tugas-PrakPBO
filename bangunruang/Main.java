
package bangunruang;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int pilih,sisi,panjang,lebar,tinggi,jari2;
        Scanner input = new Scanner(System.in);
        System.out.println("=====MENU=====");
        System.out.println("1. Persegi");
        System.out.println("2. Kubus");
        System.out.println("3. Persegi Panjang");
        System.out.println("4. Balok");
        System.out.println("5. Lingkaran");
        System.out.println("6. Tabung");
        System.out.print("PILIH :  ");
        pilih = input.nextInt();
        
    switch (pilih){
        case 1 :
            System.out.println("PERSEGI");
            System.out.print("Masukkan sisi persegi  = ");
            sisi = input.nextInt();
            Persegi hitungpersegi = new Persegi(sisi); 
            System.out.println("luas persegi = "+hitungpersegi.luas());
            System.out.println("keliling persegi = "+hitungpersegi.keliling());
        break;
        case 2 :
            System.out.println("KUBUS");
            System.out.print("masukkan sisi kubus  = ");
            sisi = input.nextInt();
            Kubus hitungkubus;
            hitungkubus = new Kubus(sisi);
            System.out.println("volume kubus = "+hitungkubus.volume());
            System.out.println("luaspermukaan kubus  = "+hitungkubus.luaspermukaan());
        break ;
        case 3 :
            System.out.println("PERSEGI PANJANG");
            System.out.print("masukkan panjang  = ");
            panjang = input.nextInt();
            System.out.print("masukkan lebar  = ");
            lebar = input.nextInt();
            PersegiPanjang persegipanjang = new PersegiPanjang(panjang,lebar); 
            System.out.println("luas persegi panjang= "+persegipanjang.luas());
            System.out.println("keliling persegi panjang  = "+persegipanjang.keliling());
        break;
        case 4 :
            System.out.println("BALOK");
            System.out.print("masukkan panjang balok = ");
            panjang = input.nextInt();
            System.out.print("masukkan lebar balok = ");
            lebar = input.nextInt();
            System.out.print("masukkan tinggi balok = ");
            tinggi = input.nextInt();
            Balok hitungbalok = new Balok(panjang,lebar,tinggi); 
            System.out.println("volume balok = "+hitungbalok.volume());
            System.out.println("luaspermukaan balok = "+hitungbalok.luaspermukaan());
        break;
        case 5 : 
            System.out.println("LINGKARAN");
            System.out.print("masukkan jari-jari  = ");
            jari2 = input.nextInt();
            Lingkaran lingkaran = new Lingkaran(jari2); 
            System.out.println("luas lingkaran= "+lingkaran.luas());
            System.out.println("keliling persegi panjang  = "+lingkaran.keliling());
        break;
        case 6 :
            System.out.println("TABUNG");
            System.out.print("masukkan jari-jari = ");
            jari2 = input.nextInt();
            System.out.print("masukkan tinggi tabung = ");
            tinggi = input.nextInt();
           Tabung hitungtabung = new Tabung(jari2,tinggi); 
            System.out.println("volume tabung = "+hitungtabung.volume());
            System.out.println("luaspermukaan tabung = "+hitungtabung.luaspermukaan());
        break;
            
    
    }
    }
    
}
