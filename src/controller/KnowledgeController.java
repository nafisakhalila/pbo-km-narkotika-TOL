package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import java.util.ArrayList;

/**
 * Jembatan antara View dan Model.
 * Semua request dari UI lewat sini dulu sebelum sampai ke repository,
 * jadi controller-lah yang jadi satu-satunya pintu masuk ke data.
 */
public class KnowledgeController {

    private final KnowledgeRepository repository;

    public KnowledgeController() {
        this.repository = new KnowledgeRepository();
    }

    /**
     * Menambahkan putusan baru dari data mentah (biasanya hasil input form).
     * <p>
     * Urutan elemen array harus persis sama dengan urutan parameter
     * constructor {@link Putusan}. Kalau terjadi exception di sini,
     * kemungkinan besar karena dua hal:
     * <ol>
     *     <li>Format angka salah (misal kolom umur/vonis diisi huruf)</li>
     *     <li>Jumlah elemen array kurang atau lebih dari yang diharapkan</li>
     * </ol>
     *
     * @param data array data mentah sesuai urutan field Putusan
     * @return true jika berhasil disimpan, false jika terjadi kesalahan
     */
    public boolean tambahPutusan(String[] data) {
        try {
            Putusan p = new Putusan(
                    data[0], data[1], data[2], data[3],
                    Integer.parseInt(data[4]), data[5],
                    Double.parseDouble(data[6]), data[7], data[8],
                    Integer.parseInt(data[9]), Double.parseDouble(data[10]), data[11]
            );
            repository.simpan(p);
            return true;
        } catch (Exception e) {
            System.err.println("Gagal menambahkan putusan: " + e.getMessage());
            return false;
        }
    }

    /**
     * Mencari putusan berdasarkan kata kunci.
     *
     * @param keyword kata kunci pencarian
     * @param mode    "nomor" untuk cari berdasarkan nomor perkara,
     *                selain itu dianggap cari berdasarkan nama terdakwa
     */
    public ArrayList<Putusan> cariPutusan(String keyword, String mode) {
        if (mode.equalsIgnoreCase("nomor")) {
            ArrayList<Putusan> hasil = new ArrayList<>();
            Putusan p = repository.cariByNomor(keyword);
            if (p != null) {
                hasil.add(p);
            }
            return hasil;
        }

        return repository.cariByNama(keyword);
    }

    /**
     * Memfilter data putusan berdasarkan kriteria tertentu.
     *
     * @param kriteria "jenis" untuk filter berdasarkan jenis narkotika,
     *                 selain itu dianggap filter berdasarkan pengadilan
     */
    public ArrayList<Putusan> filterPutusan(String kriteria, String nilai) {
        if (kriteria.equalsIgnoreCase("jenis")) {
            return repository.filterByJenis(nilai);
        }

        return repository.filterByPengadilan(nilai);
    }
    /** Menghapus putusan berdasarkan nomor perkara. */
    public boolean hapusPutusan(String nomor) {
        return repository.hapus(nomor);
    }

    /** Menghitung statistik dari seluruh data putusan yang tersimpan. */
    public StatistikPutusan getStatistik() {
        return new StatistikPutusan(repository.getDaftarSemua());
    }

    /** Mengambil seluruh data putusan, biasanya untuk ditampilkan di tabel. */
    public ArrayList<Putusan> getSemuaPutusan() {
        return repository.getDaftarSemua();
    }
}