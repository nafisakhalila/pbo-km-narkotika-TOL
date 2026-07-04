package view;
import model.Putusan;
import model.StatistikPutusan;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ini bagian tampilan buat versi console (command line).
 * Tugasnya cuma nampilin teks ke layar sama nangkep input dari user
 * di sini fokusnya cuma "tampil" doang.
 */
public class ConsoleView {

    public int tampilkanMenu(Scanner sc) {
        System.out.println("\n=== KMS PUTUSAN PENGADILAN NARKOTIKA ===");
        System.out.println("1. Tambah Putusan");
        System.out.println("2. Tampilkan Semua Putusan");
        System.out.println("3. Cari Putusan (Nomor/Nama)");
        System.out.println("4. Filter Putusan (Jenis/Pengadilan)");
        System.out.println("5. Hapus Putusan");
        System.out.println("6. Statistik");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    /**
     * Nampilin daftar semua putusan versi ringkas (kayak tabel sederhana)
     */
    public void tampilkanDaftarPutusan(ArrayList<Putusan> list) {
        if (list.isEmpty()) {
            System.out.println("Tidak ada data untuk ditampilkan.");
            return;
        }
        System.out.println("\nNo | Nomor Perkara | Nama Terdakwa | Jenis | Vonis");
        int i = 1;
        for (Putusan p : list) {
            System.out.println(i + ". " + p.getNomorPerkara() + " | " + p.getNamaTerdakwa()
                    + " | " + p.getJenisNarkotika() + " | " + p.getVonisHukuman() + " bulan");
            i++;
        }
    }

    public void tampilkanDetail(Putusan p) {
        if (p == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }
        p.tampilkan(true);
    }

    public void tampilkanStatistik(StatistikPutusan stat) {
        stat.tampilkanLaporan();
    }
    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    public String[] inputFormPutusan(Scanner sc) {
        String[] data = new String[12];
        System.out.println("\n--- Form Tambah Putusan ---");
        System.out.print("Nomor Perkara     : "); data[0] = sc.nextLine();
        System.out.print("Pengadilan        : "); data[1] = sc.nextLine();
        System.out.print("Tanggal Putusan   : "); data[2] = sc.nextLine();
        System.out.print("Nama Terdakwa     : "); data[3] = sc.nextLine();
        System.out.print("Umur Terdakwa     : "); data[4] = sc.nextLine();
        System.out.print("Jenis Narkotika   : "); data[5] = sc.nextLine();
        System.out.print("Berat Barang Bukti: "); data[6] = sc.nextLine();
        System.out.print("Pasal Dilanggar   : "); data[7] = sc.nextLine();
        System.out.print("Peran Terdakwa    : "); data[8] = sc.nextLine();
        System.out.print("Vonis Hukuman(bln): "); data[9] = sc.nextLine();
        System.out.print("Vonis Denda       : "); data[10] = sc.nextLine();
        System.out.print("Nama Hakim        : "); data[11] = sc.nextLine();
        return data;
    }
}