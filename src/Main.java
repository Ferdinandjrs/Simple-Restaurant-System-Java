import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        menampilkanMenu();

        System.out.println("\nMaksimal 4 Pesanan (Ketik 0 jika tidak ingin mengisi pesanan ke-2, 3, dst)");

        System.out.print("Menu 1 : ");
        int pilihan1=input.nextInt();

        System.out.print("Jumlah : ");
        int jumlah1=input.nextInt();

        System.out.print("Menu 2 : ");
        int pilihan2=input.nextInt();

        System.out.print("Jumlah : ");
        int jumlah2=input.nextInt();

        System.out.print("Menu 3 : ");
        int pilihan3=input.nextInt();

        System.out.print("Jumlah : ");
        int jumlah3=input.nextInt();

        System.out.print("Menu 4 : ");
        int pilihan4=input.nextInt();

        System.out.print("Jumlah : ");
        int jumlah4=input.nextInt();


        int sub_total = jumlah1*getHarga(pilihan1) + jumlah2*getHarga(pilihan2) + jumlah3*getHarga(pilihan3)+ jumlah4*getHarga(pilihan4);

        int potonganMinuman = 0;
        String infoPromoMinuman = "";

        if(sub_total > 50000){
            if(kategori(pilihan1).equals("Minuman") && jumlah1 >= 2){
                potonganMinuman = getHarga(pilihan1);
                infoPromoMinuman = getNama(pilihan1);
            } else if(kategori(pilihan2).equals("Minuman") && jumlah2 >= 2){
                potonganMinuman = getHarga(pilihan2);
                infoPromoMinuman = getNama(pilihan2);
            } else if(kategori(pilihan3).equals("Minuman") && jumlah3 >= 2){
                potonganMinuman = getHarga(pilihan3);
                infoPromoMinuman = getNama(pilihan3);
            } else if(kategori(pilihan4).equals("Minuman") && jumlah4 >= 2){
                potonganMinuman = getHarga(pilihan4);
                infoPromoMinuman = getNama(pilihan4);
            }
        }


        int subtotalSetelahPromo = sub_total - potonganMinuman;
        int diskon = 0;
        if(subtotalSetelahPromo > 100000){
            diskon = subtotalSetelahPromo * 10 / 100;
        }
        int totalSetelahDiskon = subtotalSetelahPromo - diskon;


        int pajak = totalSetelahDiskon * 10 / 100;
        int biayaPelayanan = 20000;
        int totalBayarKeseluruhan = totalSetelahDiskon + pajak + biayaPelayanan;



        System.out.println("\n==============================");
        System.out.println("       STRUK PESANAN          ");
        System.out.println("==============================");


        if(pilihan1 >= 1 && jumlah1 > 0){
            System.out.println(getNama(pilihan1) + " x" + jumlah1 + " = Rp" + (getHarga(pilihan1)*jumlah1));
        }
        if(pilihan2 >= 1 && jumlah2 > 0){
            System.out.println(getNama(pilihan2) + " x" + jumlah2 + " = Rp" + (getHarga(pilihan2)*jumlah2));
        }
        if(pilihan3 >= 1 && jumlah3 > 0){
            System.out.println(getNama(pilihan3) + " x" + jumlah3 + " = Rp" + (getHarga(pilihan3)*jumlah3));
        }
        if(pilihan4 >= 1 && jumlah4 > 0){
            System.out.println(getNama(pilihan4) + " x" + jumlah4 + " = Rp" + (getHarga(pilihan4)*jumlah4));
        }


        System.out.println("------------------------------");

        System.out.println("Subtotal : Rp" + sub_total);

        if(potonganMinuman > 0){
            System.out.println("Promo Minuman : -Rp" + potonganMinuman);
            System.out.println("Gratis 1 " + infoPromoMinuman);
        }


        if(diskon > 0){
            System.out.println("Diskon 10% : -Rp" + diskon);
        }
        System.out.println("Pajak 10% : Rp" + pajak);
        System.out.println("Biaya Pelayanan : Rp" + biayaPelayanan);
        System.out.println("------------------------------");
        System.out.println("TOTAL BAYAR : Rp" + totalBayarKeseluruhan);
    }


    static Menu[] daftarMenu = {
            new Menu("Nasi Goreng", "Makanan", 25000),
            new Menu("Mie Ayam","Makanan",20000),
            new Menu("Ayam Geprek","Makanan",30000),
            new Menu("Sate Ayam","Makanan",35000),

            new Menu("Es Teh","Minuman",5000),
            new Menu("Jus Alpukat","Minuman",15000),
            new Menu("Kopi","Minuman",12000),
            new Menu("Air Mineral","Minuman",4000)
    };


    public static void menampilkanMenu(){

        System.out.println("========Makanan=========");

        System.out.println("1. "+daftarMenu[0].nama+" Rp."+daftarMenu[0].harga);
        System.out.println("2. "+daftarMenu[1].nama+" Rp."+daftarMenu[1].harga);
        System.out.println("3. "+daftarMenu[2].nama+" Rp."+daftarMenu[2].harga);
        System.out.println("4. "+daftarMenu[3].nama+" Rp."+daftarMenu[3].harga);

        System.out.println();

        System.out.println("===== MINUMAN =====");

        System.out.println("5. "+daftarMenu[4].nama+" Rp."+daftarMenu[4].harga);
        System.out.println("6. "+daftarMenu[5].nama+" Rp."+daftarMenu[5].harga);
        System.out.println("7. "+daftarMenu[6].nama+" Rp."+daftarMenu[6].harga);
        System.out.println("8. "+daftarMenu[7].nama+" Rp."+daftarMenu[7].harga);
    }

    public static int getHarga(int pilihan){
        switch (pilihan){

            case 1:
                return daftarMenu[0].harga;

            case 2:
                return daftarMenu[1].harga;

            case 3:
                return daftarMenu[2].harga;

            case 4:
                return daftarMenu[3].harga;

            case 5:
                return daftarMenu[4].harga;

            case 6:
                return daftarMenu[5].harga;

            case 7:
                return daftarMenu[6].harga;

            case 8:
                return daftarMenu[7].harga;

            default:
                return 0;
        }
    }

    public static String getNama(int pilihan){

        switch(pilihan){

            case 1:
                return daftarMenu[0].nama;
            case 2:
                return daftarMenu[1].nama;
            case 3:
                return daftarMenu[2].nama;
            case 4:
                return daftarMenu[3].nama;
            case 5:
                return daftarMenu[4].nama;
            case 6:
                return daftarMenu[5].nama;
            case 7:
                return daftarMenu[6].nama;
            case 8:
                return daftarMenu[7].nama;

            default:return "-";

        }

    }

    public static String kategori(int pilihan) {
        switch (pilihan){
            case 1:
            case 2:
            case 3:
            case 4:
                return "Makanan";

            case 5:
            case 6:
            case 7:
            case 8:
                return "Minuman";
            default:
                return "";
        }
    }
}