import java.util.Scanner;

public class One_DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Jumlah angka yang ingin diinput: ");
        int jumlahInput = scan.nextInt();
        scan.nextLine(); // buang enter

        for (int i = 0; i < jumlahInput; i++) {
            System.out.print("Masukkan angka: ");
            String input = scan.nextLine();

            try {
                long nilai = Long.parseLong(input);

                System.out.println(input + " can be fitted in:");
                if (nilai >= Byte.MIN_VALUE && nilai <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (nilai >= Short.MIN_VALUE && nilai <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (nilai >= Integer.MIN_VALUE && nilai <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                if (nilai >= Long.MIN_VALUE && nilai <= Long.MAX_VALUE) {
                    System.out.println("* long");
                }

            } catch (NumberFormatException e) {
                System.out.println(input + " can't be fitted anywhere.");
            }
        }

        scan.close();
    }
}
