package perpustakaan;

import java.util.Map;

/**
 * Mencetak hasil sesuai format output README:
 *
 *   Total buku dipinjam: <angka>
 *   Peminjam terbanyak: <nama> (<jumlah> buku)
 *
 * Dan tambahan daftar semua pengunjung hari ini.
 */
public class Formatter {

    /**
     * Format laporan utama (2 baris sesuai README).
     * @param hasil Hasil dari Processor
     * @return String siap cetak
     */
    public String format(Processor.Hasil hasil) {
        return "Total buku dipinjam: " + hasil.totalDipinjam + "\n"
             + "Peminjam terbanyak: "  + hasil.namaTerbanyak
             + " ("                    + hasil.jumlahTerbanyak + " buku)";
    }

    /**
     * Format daftar semua pengunjung beserta jumlah buku yang dipinjam hari ini.
     * @param hasil Hasil dari Processor
     * @return String tabel daftar pengunjung
     */
    public String formatDaftarPengunjung(Processor.Hasil hasil) {
        StringBuilder sb = new StringBuilder();
        sb.append("Daftar Pengunjung Hari Ini:\n");
        sb.append(String.format("  %-20s %s%n", "Nama Pengunjung", "Jumlah Buku"));
        sb.append("  " + "-".repeat(32) + "\n");

        for (Map.Entry<String, Integer> entry : hasil.daftarPengunjung.entrySet()) {
            sb.append(String.format("  %-20s %d buku%n", entry.getKey(), entry.getValue()));
        }

        sb.append("  " + "-".repeat(32) + "\n");
        sb.append(String.format("  %-20s %d buku%n", "Total", hasil.totalDipinjam));
        return sb.toString();
    }
}
