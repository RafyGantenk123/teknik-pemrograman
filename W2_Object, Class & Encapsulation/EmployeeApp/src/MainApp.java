import java.util.Scanner;
import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        int id = 1;
        String lanjut = "y";

        while (lanjut.equalsIgnoreCase("y")) {
            System.out.println("=== Input Data Karyawan ===");

            System.out.print("Nama: ");
            String nama = sc.nextLine();

            System.out.print("Departemen: ");
            String deptInput = sc.nextLine();
            Department dept = new Department(deptInput);

            System.out.print("Tipe Karyawan (Tetap/Kontrak): ");
            String typeInput = sc.nextLine();
            EmploymentType type = new EmploymentType(typeInput);

            System.out.print("Gaji: ");
            double gaji = sc.nextDouble();
            sc.nextLine(); // buang enter

            Employee emp = new Employee(id, nama, dept, type, gaji);
            service.addEmployee(emp);

            id++;

            System.out.print("Tambah karyawan lagi? (y/n): ");
            lanjut = sc.nextLine();
            System.out.println();
        }

        System.out.println("=== Selesai Input Data ===");
        System.out.println("Total Employee: " + EmployeeService.getTotalEmployee());
    }
}