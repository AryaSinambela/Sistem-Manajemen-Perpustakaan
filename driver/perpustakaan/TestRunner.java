package perpustakaan;

import java.util.List;
import java.util.Scanner;

/**
 * Driver / Test runner.
 *
 * Test Case 1 : mengecek output laporan sesuai README
 *               (total dipinjam + peminjam terbanyak)
 * Test Case 2 : menampilkan daftar SEMUA pengunjung
 *               beserta jumlah buku yang dipinjam hari ini
 *
 * Compile : javac -d out src/perpustakaan/*.java driver/perpustakaan/*.java
 * Run     : java -cp out perpustakaan.TestRunner
 */
public class TestRunner {

    private static int passed = 0;
    private static int failed = 0;

    // ── Mini framework ────────────────────────────────────────────────────────

    static void assertEquals(String desc, Object actual, Object expected) {
        if (expected.equals(actual)) {
            System.out.println("  [PASS] " + desc);
            passed++;
        } else {
            System.out.println("  [FAIL] " + desc);
            System.out.println("         Expected : " + expected);
            System.out.println("         Actual   : " + actual);
            failed++;
        }
    }

    static void describe(String label, Runnable fn) {
        System.out.println("\n>> " + label);
        fn.run();
    }

    // ── Helper ────────────────────────────────────────────────────────────────

    static Processor.Hasil jalankan(String inputSimulasi) {
        Scanner scanner = new Scanner(inputSimulasi);
        List<Peminjaman> daftar = new Parser(scanner).bacaInput();
        return new Processor().proses(daftar);
    }

    // ── Test Case 1: laporan utama sesuai README ──────────────────────────────

    static void testCase1() {
        describe("Test Case 1 -- Laporan utama (sesuai README)", () -> {
            String input   = "5\nAni B001\nBudi B002\nAni B003\nCici B004\nBudi B005\n";
            Processor.Hasil hasil  = jalankan(input);
            String[]        output = new Formatter().format(hasil).split("\n");

            assertEquals("baris 1 total benar",              output[0], "Total buku dipinjam: 5");
            assertEquals("baris 2 peminjam terbanyak benar", output[1], "Peminjam terbanyak: Ani (2 buku)");
        });
    }

    // ── Test Case 2: daftar semua pengunjung hari ini ─────────────────────────

    static void testCase2() {
        System.out.println("\n>> Test Case 2 -- Daftar semua pengunjung hari ini");
        String input = "6\nDeni B010\nDeni B011\nEka B012\nDeni B013\nFira B014\nDeni B015\n";
        Processor.Hasil hasil = jalankan(input);
        System.out.println(new Formatter().formatDaftarPengunjung(hasil));
    }

    // ── Main ──────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        testCase1();
        testCase2();

        System.out.println("-".repeat(40));
        System.out.println("  Total  : " + (passed + failed) + " test");
        System.out.println("  Passed : " + passed);
        System.out.println("  Failed : " + failed);
        System.out.println("-".repeat(40) + "\n");

        if (failed > 0) System.exit(1);
    }
}
