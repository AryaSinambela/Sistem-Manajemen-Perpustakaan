package perpustakaan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Membaca input peminjaman secara interaktif dari keyboard.
 *
 * Sesuai README format input:
 *   Baris 1       : N (jumlah data peminjaman)
 *   Baris 2..N+1  : <nama_pengunjung> <id_buku>
 */
public class Parser {

    private final Scanner scanner;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Membaca N dari keyboard, lalu membaca N baris data peminjaman.
     * @return List berisi seluruh data peminjaman
     */
    public List<Peminjaman> bacaInput() {
        System.out.print("Masukkan jumlah data peminjaman (N): ");
        int n = Integer.parseInt(scanner.nextLine().trim());

        if (n < 1 || n > 10_000) {
            throw new IllegalArgumentException(
                "Jumlah data harus antara 1 dan 10.000. Input: " + n
            );
        }

        List<Peminjaman> daftar = new ArrayList<>();

        System.out.println("Masukkan data peminjaman (format: NamaPengunjung IDBuku):");
        for (int i = 1; i <= n; i++) {
            System.out.print("  Data ke-" + i + ": ");
            String line  = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");

            if (parts.length < 2) {
                throw new IllegalArgumentException(
                    "Format salah pada data ke-" + i + ": \"" + line + "\""
                );
            }

            String nama   = parts[0];
            String idBuku = parts[1];

            if (nama.length() > 50) {
                throw new IllegalArgumentException(
                    "Nama terlalu panjang (maks. 50 karakter): " + nama
                );
            }

            daftar.add(new Peminjaman(nama, idBuku));
        }

        return daftar;
    }
}
