# KMS Putusan Pengadilan Narkotika
Knowledge Mnagement System (KMS) berbasis java untuk mengelola data putusan pengadilan pidana narkotika, dibangun dengan arsitektur MVC (Model-View-Controller).
Tugas Besar Mata Kuliah Pemrograman Berorientasi Objek (PBO)
Semester Genap 2025/2026

# Deskripsi Proyek
Aplikasi ini mengelola data putusan pengadilan narkotika (Identitas terdakwa, jenis, dan berat barang bukti, pasal yang dilanggar, serta vonis yang dijatuhkan) menggunakan konsep OOP dan arsitektur MVC. Aplikasi menyediakan fitur:
- Manajemen data, tambah, tampilkan, dan hapus data putusan
- Pencarian dan filter - pencarian berdasarkan nomor perkara/nama terdakwa, filter berdasarkan jenis narkotika/pengadilan
- Statistik - rata-rata vonis, rata-rata denda, jenis narkotika terbanyak, distribusi peran terdakwa, dan distribusi kategori hukuman
- Validasi input dan exception handling - mencegah program crash akibat input yang tidak valid
- Antarmuka GUI (JavaFX) - sebagai fitur tambahan diluar tampilan console

Dataset yang digunakan berasal dari rekap 50 putusan pidana Narkotika (PN Surabaya & PN Serui, 2024-2025).

# Konsep OOP yang diterapkan 
- Enkapsulasi - field bersifat private, diakses lewat getter/setter dengan validasi
- Pewarisan (Inheritance) - putusan extends EntitasHukum
- Interface - Putusan implements Rekapitulasi
- Polimorfisme - method overridding (toString(), getRingkasanKasus(), ringkasan(), getTotalKerugian()) dan method overloading (tampilkan() / tampilkan(boolean) )
- Static member - jumlahDibuat (static field) dan getJumlahDibuat() (static method)
- Exception Handling - try-catch di InputHandler dan KnwoeledgeController
- Koleksi Data - ArrayList<Putusan> sebagai struktur data utama

# Cara Kompilasi
Menggunakan IntelliJ IDEA (disarankan):
- Buka project ini sebagai project IntelliJ
- Pastikan project SDK sudah di-set ke JDK 11 atau lebih baru (File->Project Structure->Project)
- Klik Build->Rebuild Project

Menggunakan Command Line:
javac -d out -sourcepath src src/app/Main.java

Cara Menjalankan 
Versi Console (wajib)
Jalankan src/app/Main.java:
java -cp out app.Main 
Atau Klik kanan Main.java di IntelliJ->Run'Main.main()'

Versi GUI JavaFX
Membutuhkan JavaFX SDK terpisah(download di openjfx.io) dan konfigurasi VM options:
--module-path "<path-ke-javafx-sdk>/lib" --add-modulesjavafx.controls,javafx.fxml

Jalankan src/app/MainFX.java melalui IntelliJ dengan Run Configuration yang sudah diberi VM options diatas 

Anggota Kelompok:
- Olivia Saqina Wardany (202510370110057) View / GUI Designer
- Nafisa khalila Rahman (202510370110075) / Model/Knowledge Engineer
- Dwi Susilaningtyas (202510370110076) / Controller/Backend Developer

#Version Control
Repository ini dikelola menggunakan Git dengan strategi branching:
main - branch produksi
develop - branch integrasi 
feature/model, feature/view, feature/controller - branch pengembangan per layer 
Seluruh perubahan dikelola melalui Pull Request dengan review sebelum di merge ke develop.

