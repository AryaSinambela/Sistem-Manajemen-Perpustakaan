# Compile keduanya sekaligus
javac -d out src/perpustakaan/*.java driver/perpustakaan/*.java

# Jalankan test driver
java -cp out perpustakaan.Main        # program interaktif
java -cp out perpustakaan.TestRunner  # test driver