package perpustakaan;

/**
 * Model satu record peminjaman buku.
 * Setiap pengunjung meminjam tepat satu buku per record.
 *
 * Sesuai README:
 *   Format baris: <nama_pengunjung> <id_buku>
 *   Panjang nama : maks. 50 karakter, tanpa spasi
 *   Format ID    : huruf + angka (contoh: B001, C123)
 */
public class Peminjaman {

    private final String namaPengunjung;
    private final String idBuku;

    public Peminjaman(String namaPengunjung, String idBuku) {
        this.namaPengunjung = namaPengunjung;
        this.idBuku         = idBuku;
    }

    public String getNamaPengunjung() { return namaPengunjung; }
    public String getIdBuku()         { return idBuku; }

    @Override
    public String toString() {
        return namaPengunjung + " " + idBuku;
    }
}
