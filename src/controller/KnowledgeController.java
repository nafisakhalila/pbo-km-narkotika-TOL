package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import java.util.ArrayList;

/** jembatan antara View sama Model
semua request dari UI lewat sini dulu sebelum sampe ke repository*/
public class KnowledgeController {

    private KnowledgeRepository repository;

    public KnowledgeController() {
        repository = new KnowledgeRepository();
    }

    /**
     * Nambahin putusan baru dari data mentah
     * Urutan array-nya harus pas sama urutan constructor Putusan, kalo
     * kena catch di sini bisa jadi 2 sebab: format angkanya salah
     * (misal umur/vonis diisi huruf), atau array-nya kurang/lebih elemen
     * @return true kalo berhasil disimpan, false kalo ada yang error
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
            System.out.println("DEBUG ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**cari putusan, mode-nya cuma dua: "nomor" atau "nama"*/
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

    /** filter data, kriteria "jenis" (narkotika) atau "pengadilan"*/
    public ArrayList<Putusan> filterPutusan(String kriteria, String nilai) {
        if (kriteria.equalsIgnoreCase("jenis")) {
            return repository.filterByJenis(nilai);
        }

        return repository.filterByPengadilan(nilai);
    }

    /** hapus */
    public boolean hapusPutusan(String nomor) {
        return repository.hapus(nomor);
    }

    /** ngitung statistik dari semua data yang ada*/
    public StatistikPutusan getStatistik() {
        return new StatistikPutusan(repository.getDaftarSemua());
    }

    /** buat nampilin semua data di tabel/list view */
    public ArrayList<Putusan> getSemuaPutusan() {
        return repository.getDaftarSemua();
    }
}



