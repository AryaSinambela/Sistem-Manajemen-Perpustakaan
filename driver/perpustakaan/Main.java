package perpustakaan;

import java.util.List;
import java.util.Scanner;

/**
 * @author: 12S24017 - Arya Pratama Sinambela
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("  Sistem Manajemen Perpustakaan");
        System.out.println("=====================================");

        try {
            Parser    parser    = new Parser(scanner);
            Processor processor = new Processor();
            Formatter formatter = new Formatter();

            List<Peminjaman>  daftar = parser.bacaInput();
            Processor.Hasil   hasil  = processor.proses(daftar);

            System.out.println("\n--- Hasil Laporan ---");
            System.out.println(formatter.format(hasil));

        } catch (Exception e) {
            System.err.println("\nError: " + e.getMessage());
            System.exit(1);
        } finally {
            scanner.close();
        }
    }
}
