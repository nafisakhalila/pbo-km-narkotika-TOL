package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class ini dipakai buat ngitung statistik dari data Putusan yang udah diinput.
 * Isinya rata-rata vonis, rata-rata denda, jenis narkotika paling sering muncul,
 * sama distribusi peran terdakwa (pengedar, kurir, dll).
 *
 * Dibuat untuk Tugas Besar PBO - Sistem Informasi Putusan Narkotika
 */
public class StatistikPutusan {

    // atribut2 hasil perhitungan statistik
    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiPeran;

    // constructor, langsung hitung pas objek dibuat
    public StatistikPutusan(ArrayList<Putusan> daftar) {
        hitungSemua(daftar);
    }

    // fungsi utama buat proses semua perhitungan
    private void hitungSemua(ArrayList<Putusan> daftar) {
        totalPutusan = daftar.size();

        // kalau datanya kosong, ga usah dihitung, langsung kasih nilai default aja
        if (totalPutusan == 0) {
            rataRataVonis = 0;
            rataRataDenda = 0;
            jenisNarkotikaTerbanyak = "-";
            distribusiPeran = new String[0];
            return;
        }
        double totalVonis = 0;
        double totalDenda = 0;

        // pakai HashMap buat nyimpen jumlah kemunculan tiap jenis & peran
        Map<String, Integer> hitungJenis = new HashMap<>();
        Map<String, Integer> hitungPeran = new HashMap<>();

        for (Putusan p : daftar) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            // update counter jenis narkotika
            String jenis = p.getJenisNarkotika();
            hitungJenis.put(jenis, hitungJenis.getOrDefault(jenis, 0) + 1);

            // update counter peran terdakwa
            String peran = p.getPeranTerdakwa();
            hitungPeran.put(peran, hitungPeran.getOrDefault(peran, 0) + 1);
        }
        rataRataVonis = totalVonis / totalPutusan;
        rataRataDenda = totalDenda / totalPutusan;

        jenisNarkotikaTerbanyak = cariTerbanyak(hitungJenis);

        // ubah map peran jadi array string biar gampang ditampilin
        distribusiPeran = new String[hitungPeran.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : hitungPeran.entrySet()) {
            distribusiPeran[idx] = entry.getKey() + ": " + entry.getValue() + " kasus";
            idx++;
        }
    }

    // cari key dengan value paling besar di dalam map (dipakai buat cari jenis narkotika terbanyak)
    private String cariTerbanyak(Map<String, Integer> map) {
        String terbanyak = "-";
        int maks = -1;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maks) {
                maks = entry.getValue();
                terbanyak = entry.getKey();
            }
        }
        return terbanyak;
    }

    // buat nampilin laporan ke console, format tabel sederhana
    public void tampilkanLaporan() {
        System.out.println("\n=== LAPORAN STATISTIK PUTUSAN ===");
        System.out.println("Total Putusan            : " + totalPutusan);
        System.out.printf("Rata-rata Vonis           : %.2f bulan%n", rataRataVonis);
        System.out.printf("Rata-rata Denda           : Rp%.2f%n", rataRataDenda);
        System.out.println("Jenis Narkotika Terbanyak : " + jenisNarkotikaTerbanyak);
        System.out.println("Distribusi Peran Terdakwa :");

        for (String d : distribusiPeran) {
            System.out.println("  - " + d);
        }
    }

    // getter2 standar, dipakai kalau data statistiknya mau dipakai di class lain
    public int getTotalPutusan() {
        return totalPutusan;
    }

    public double getRataRataVonis() {
        return rataRataVonis;
    }

    public double getRataRataDenda() {
        return rataRataDenda;
    }

    public String getJenisNarkotikaTerbanyak() {
        return jenisNarkotikaTerbanyak;
    }

    public String[] getDistribusiPeran() {
        return distribusiPeran;
    }
}