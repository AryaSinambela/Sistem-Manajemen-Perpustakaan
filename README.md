# 📚 Sistem Manajemen Perpustakaan

> Masalah pemrograman bertema perpustakaan — struktur data & algoritma pencarian

---

## 📖 Cerita / Latar Belakang

Pak Rudi adalah seorang pustakawan di **Perpustakaan Kota Balige**. Setiap hari, ia mencatat peminjaman buku oleh para pengunjung. Setiap buku memiliki ID unik dan setiap pengunjung dapat meminjam lebih dari satu buku.

Suatu sore, kepala perpustakaan meminta Pak Rudi untuk membuat laporan:

> *"Berapa total buku yang sedang dipinjam hari ini, dan siapa pengunjung yang meminjam buku terbanyak?"*

Bantulah Pak Rudi menulis program untuk menjawab pertanyaan tersebut berdasarkan data peminjaman yang ada!

---

## 📥 Format Input

```
N
<nama_pengunjung_1> <id_buku_1>
<nama_pengunjung_2> <id_buku_2>
...
<nama_pengunjung_N> <id_buku_N>
```

| Baris | Keterangan |
|-------|------------|
| Baris 1 | `N` — jumlah data peminjaman (integer) |
| Baris 2 s/d N+1 | `<nama_pengunjung> <id_buku>` — dipisah satu spasi |

---

## 📤 Format Output

```
Total buku dipinjam: <angka>
Peminjam terbanyak: <nama> (<jumlah> buku)
```

| Baris | Keterangan |
|-------|------------|
| Baris 1 | Total seluruh data peminjaman |
| Baris 2 | Nama pengunjung dengan peminjaman terbanyak beserta jumlahnya |

> **Catatan tie-breaking:** Jika ada dua pengunjung dengan jumlah peminjaman yang sama, tampilkan nama yang **pertama kali muncul** dalam data.

---

## 🧪 Test Case

### ✅ Test Case 1 — Kasus Normal

**Input:**
```
5
Ani B001
Budi B002
Ani B003
Cici B004
Budi B005
```

**Output:**
```
Total buku dipinjam: 5
Peminjam terbanyak: Ani (2 buku)
```

**Penjelasan:**
Ada 5 data peminjaman. Ani meminjam 2 buku (B001, B003), Budi meminjam 2 buku (B002, B005), dan Cici meminjam 1 buku (B004). Karena Ani dan Budi memiliki jumlah yang sama, dipilih **Ani** karena muncul lebih dahulu dalam data.

---

### ✅ Test Case 2 — Satu Pengunjung Dominan

**Input:**
```
6
Deni B010
Deni B011
Eka B012
Deni B013
Fira B014
Deni B015
```

**Output:**
```
Total buku dipinjam: 6
Peminjam terbanyak: Deni (4 buku)
```

**Penjelasan:**
Dari 6 data peminjaman, Deni meminjam 4 buku (B010, B011, B013, B015), Eka 1 buku (B012), dan Fira 1 buku (B014). **Deni** jelas merupakan peminjam terbanyak.

---

## 📏 Batasan

| Parameter | Nilai |
|-----------|-------|
| Jumlah data | `1 ≤ N ≤ 10.000` |
| Panjang nama | Maks. 50 karakter, tanpa spasi |
| Format ID Buku | Huruf + angka (contoh: `B001`, `C123`) |
| Tie-breaking | Tampilkan nama yang **pertama muncul** jika nilai sama |

---

## 💡 Petunjuk Implementasi

- Gunakan **dictionary / hashmap** untuk menghitung jumlah peminjaman per pengunjung.
- Iterasi data secara berurutan untuk menjaga aturan tie-breaking.
- Total peminjaman sama dengan nilai `N` (jumlah baris data).

---

*Selamat mengerjakan! 🎉*
