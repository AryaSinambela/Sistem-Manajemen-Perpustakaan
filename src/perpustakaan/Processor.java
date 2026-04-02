package perpustakaan;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Memproses data peminjaman sesuai petunjuk implementasi README:
 *   - Gunakan hashmap untuk menghitung jumlah peminjaman per pengunjung.
 *   - Iterasi data secara berurutan untuk menjaga aturan tie-breaking.
 *   - Total peminjaman sama dengan nilai N (jumlah baris data).
 */
public class Processor {

    public static class Hasil {
        public final int                 totalDipinjam;   // = N sesuai README
        public final String              namaTerbanyak;   // pemenang, dengan tie-breaking
        public final int                 jumlahTerbanyak; // jumlah buku si pemenang
        public final Map<String, Integer> daftarPengunjung; // semua pengunjung + jumlahnya

        public Hasil(int totalDipinjam, String namaTerbanyak, int jumlahTerbanyak,
                     Map<String, Integer> daftarPengunjung) {
            this.totalDipinjam    = totalDipinjam;
            this.namaTerbanyak    = namaTerbanyak;
            this.jumlahTerbanyak  = jumlahTerbanyak;
            this.daftarPengunjung = daftarPengunjung;
        }
    }

    /**
     * Menghitung laporan dari daftar peminjaman.
     *
     * Tie-breaking: jika dua pengunjung memiliki jumlah yang sama,
     * tampilkan yang PERTAMA KALI MUNCUL dalam data (sesuai README).
     * LinkedHashMap menjaga urutan insert sehingga iterasi pertama = kemunculan pertama.
     *
     * @param daftarPeminjaman List data peminjaman dari Parser
     * @return Hasil berisi total, nama terbanyak, jumlahnya, dan daftar semua pengunjung
     */
    public Hasil proses(List<Peminjaman> daftarPeminjaman) {
        // LinkedHashMap: urutan insert terjaga untuk tie-breaking
        Map<String, Integer> hitungan = new LinkedHashMap<>();

        for (Peminjaman p : daftarPeminjaman) {
            hitungan.merge(p.getNamaPengunjung(), 1, Integer::sum);
        }

        String namaTerbanyak   = null;
        int    jumlahTerbanyak = 0;

        // Iterasi berurutan — yang muncul lebih dulu menang jika nilai sama
        for (Map.Entry<String, Integer> entry : hitungan.entrySet()) {
            if (entry.getValue() > jumlahTerbanyak) {
                jumlahTerbanyak = entry.getValue();
                namaTerbanyak   = entry.getKey();
            }
        }

        // Total = N = ukuran list (sesuai README)
        return new Hasil(daftarPeminjaman.size(), namaTerbanyak, jumlahTerbanyak, hitungan);
    }
}
