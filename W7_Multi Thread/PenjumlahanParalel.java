import java.util.Scanner;

public class PenjumlahanParalel {
    
    // Variabel total dipakai bersama oleh semua thread
    static long total = 0;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Input jumlah thread dari user
        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = sc.nextInt();

        // Input angka akhir yang akan dijumlahkan
        System.out.print("Masukkan angka akhir: ");
        int angkaAkhir = sc.nextInt();

        // Menentukan ukuran range untuk tiap thread
        // Contoh: 1000 / 4 = 250
        int chunk = angkaAkhir / jumlahThread;

        // Array untuk menyimpan semua thread
        Thread[] threads = new Thread[jumlahThread];

        // Membuat thread sebanyak jumlahThread
        for (int i = 0; i < jumlahThread; i++) {
            
            // Menentukan angka awal untuk thread ke-i
            // Contoh thread pertama mulai dari 1
            int start = (i * chunk) + 1;

            int end;

            // Jika thread terakhir, ambil sisa angka sampai angka akhir
            if (i == jumlahThread - 1) {
                end = angkaAkhir;
            } else {
                // Selain thread terakhir, range sesuai chunk
                end = (i + 1) * chunk;
            }

            // Membuat thread baru
            threads[i] = new Thread(() -> {

                // Variabel untuk menyimpan hasil parsial thread
                long hasilParsial = 0;

                // Menjumlahkan angka dari start sampai end
                for (int j = start; j <= end; j++) {
                    hasilParsial += j;
                }

                // Menampilkan hasil parsial thread
                System.out.println(
                    Thread.currentThread().getName() +
                    " menjumlahkan " + start +
                    " - " + end +
                    " = " + hasilParsial
                );

                // synchronized digunakan agar hanya satu thread
                // yang boleh mengubah variabel total pada satu waktu
                synchronized (PenjumlahanParalel.class) {
                    total += hasilParsial;
                }
            });

            // Memberi nama thread
            threads[i].setName("Thread-" + (i + 1));

            // Menjalankan thread
            threads[i].start();
        }

        // Menunggu semua thread selesai
        for (Thread thread : threads) {
            thread.join();
        }

        // Menampilkan hasil akhir setelah semua thread selesai
        System.out.println("Total Akhir: " + total);

        // Menutup scanner
        sc.close();
    }
}