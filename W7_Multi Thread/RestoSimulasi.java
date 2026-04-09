// Kelas Resto merepresentasikan restoran dengan stok ayam
class Resto {
    
    // Variabel stok ayam, awalnya tersedia 100
    private int chickenStock = 100;

    // Method synchronized agar hanya satu thread/kasir
    // yang bisa mengakses method ini dalam satu waktu
    public synchronized void serveCustomer(String cashierName) {
        
        // Mengecek apakah stok ayam masih tersedia
        if (chickenStock > 0) {
            try {
                // Simulasi proses pelayanan pelanggan selama 10 ms
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // Menangani jika thread terganggu saat sleep
            }

            // Mengurangi stok ayam sebanyak 1
            chickenStock--;

            // Menampilkan kasir yang berhasil menjual ayam
            // beserta sisa stok saat ini
            System.out.println(cashierName + 
                " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            // Jika stok habis, tampilkan pesan gagal
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    // Method untuk mengambil sisa stok ayam saat ini
    public int getRemainingStock() {
        return chickenStock;
    }
}

// Kelas utama untuk menjalankan simulasi restoran
public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        
        // Membuat objek restoran
        Resto ayamJuicyLuicyGallagher = new Resto();

        // Membuat task yang akan dijalankan oleh setiap thread/kasir
        Runnable task = () -> {
            
            // Setiap kasir mencoba melayani pelanggan sebanyak 40 kali
            for (int i = 0; i < 40; i++) {
                
                // Memanggil method serveCustomer
                // dengan nama thread/kasir yang sedang berjalan
                ayamJuicyLuicyGallagher.serveCustomer(
                    Thread.currentThread().getName()
                );
            }
        };

        // Membuat 3 thread yang merepresentasikan 3 kasir berbeda
        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        // Menjalankan ketiga thread
        kasir1.start();
        kasir2.start();
        kasir3.start();

        // Menunggu semua thread selesai sebelum lanjut
        kasir1.join();
        kasir2.join();
        kasir3.join();

        // Menampilkan hasil akhir stok ayam setelah semua kasir selesai
        System.out.println(
            "--- HASIL AKHIR STOK: " + 
            ayamJuicyLuicyGallagher.getRemainingStock() + 
            " ---"
        );
    }
}