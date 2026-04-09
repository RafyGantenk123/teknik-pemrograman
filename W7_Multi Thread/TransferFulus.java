class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci objek acc1 agar tidak terjadi race condition
                System.out.println("[Thread 1] Mengunci acc 1");
                try { Thread.sleep(100); } catch (Exception e) {}  // Simulasi dengan memberikan jeda. 
                // Kalau ada interupsi, tangkap exception-nya agar program tidak crash

            synchronized (acc2) { // Mengunci objek acc2 agar tidak terjadi race condition
            System.out.println("[Thread 1] mengunci acc 2");
            acc2.balance += acc1.balance;

                }
            }
        });

       // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 terlebih dahulu agar tidak terjadi race condition
                System.out.println("[Thread 2] Mengunci acc 1");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulasi dengan memberikan jeda. 
                // Kalau ada interupsi, tangkap exception-nya agar program tidak crash

                synchronized (acc2) { // Mengunci acc 2
                    System.out.println("[Thread 2] Mengunci acc 2");
                    acc1.balance += acc2.balance;
                }
            }
        }); 

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}


