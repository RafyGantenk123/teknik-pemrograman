import java.util.Scanner;

class Restaurant {
    private String[] nama_makanan; 
    private double[] harga_makanan; 
    private int[] stok;
    private static byte id = 0;

    public Restaurant() { 
        nama_makanan = new String[10];
        harga_makanan = new double[10]; 
        stok = new int[10];
    }

    // setter
    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama; 
        this.harga_makanan[id] = harga; 
        this.stok[id] = stok;
        id++;
    }

    // getter
    public String getNamaMakanan(int index){
        return nama_makanan[index];
    }

    public double getHargaMakanan(int index){
        return harga_makanan[index];
    }

    public int getStok(int index){
        return stok[index];
    }



    public void tampilMenuMakanan() {
        System.out.println("=== DAFTAR MENU ===");
        for (int i = 0; i < id; i++) {
            if (isOutOfStock(i)) { 
                System.out.println(i + ". " +
                    nama_makanan[i] + " [HABIS] \tRp. " + harga_makanan[i]);
            } else {
                System.out.println(i + ". " +
                    nama_makanan[i] + " [" + stok[i] + "] \tRp. " + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int index) { 
        return stok[index] == 0;
    }

    // fitur pemesanan
    public void pesanMenu(int index, int jumlah){
        if(index < 0 || index >= id){
            System.out.println("Menu yang dipesan tidak valid");
            return;
        }

        if (jumlah <= 0){
            System.out.println("Jumlah pesanan tidak valid");
            return;
        }

        if (isOutOfStock(index)) {
            System.out.println("Menu ini sudah HABIS dan tidak bisa dipesan.");
            return;
        }

        if(stok[index] < jumlah){
            System.out.println("Gagal memesan! Stok tidak mencukupi!");
            return;
        }

        stok[index] -= jumlah;
        System.out.println("Pesanan berhasil: " 
            + jumlah + " " + nama_makanan[index]);
    }
}






public class RestaurantMain {
    public static void main(String[] args) { 
        Restaurant menu = new Restaurant();
        Scanner sc = new Scanner(System.in);

        menu.tambahMenuMakanan("Pizza", 250000, 20); 
        menu.tambahMenuMakanan("Spaghetti", 80000, 20); 
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30); 
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30); 

        int pilih, jumlah;
        boolean lanjut = true;

        while (lanjut) {
            menu.tampilMenuMakanan();

            System.out.print("Pilih menu (index): ");
            pilih = sc.nextInt();

            System.out.print("Jumlah pesanan: ");
            jumlah = sc.nextInt();

            menu.pesanMenu(pilih, jumlah);

            System.out.print("Pesan lagi? (1 = ya, 0 = tidak): ");
            int jawab = sc.nextInt();

            if (jawab == 0) {
                lanjut = false;
            }
        }

        System.out.println("Terima kasih telah memesan!");
    }
}


